package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;

import java.util.Optional;

public class StraightMovePattern extends MovePattern {

    public StraightMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return true;
    }

    @Override
    public void calculateMoveDirectionAndCount() {
        if (changeOnlyRank() && increaseRank()) {
            initDirectionAndCount(presentPosition.getRankNumber(), targetPosition.getRankNumber(), Direction.FRONT);
        }

        if (changeOnlyRank() && decreaseRank()) {
            initDirectionAndCount(presentPosition.getRankNumber(), targetPosition.getRankNumber(), Direction.BACK);
        }

        if (changeOnlyFile() && increaseFile()) {
            initDirectionAndCount(presentPosition.getFileNumber(), targetPosition.getFileNumber(), Direction.RIGHT);
        }

        if (changeOnlyFile() && decreaseFile()) {
            initDirectionAndCount(presentPosition.getFileNumber(), targetPosition.getFileNumber(), Direction.LEFT);
        }
    }

    @Override
    public boolean checkObstructionOnMovePath(ChessBoard chessBoard) {
        boolean isObstruction = true;
        if (MovePatternFactory.checkHeightStraight(this.presentPosition, this.targetPosition)) {
            int moveSubCount = this.presentPosition.getRankNumber() - this.targetPosition.getRankNumber();
            if (this.direction.equals(Direction.BACK) && moveSubCount < 0) {
                int moveSubCountExceptTargetPosition = moveSubCount + 1;
                isObstruction = validObstructionOnBackRoad(chessBoard, this.presentPosition.getFile(), this.presentPosition.getRankNumber(), moveSubCountExceptTargetPosition);
            }

            if (this.direction.equals(Direction.FRONT) && moveSubCount > 0) {
                int moveSubCountExceptTargetPosition = moveSubCount - 1;
                isObstruction = validObstructionOnFrontRoad(chessBoard, this.presentPosition.getFile(), this.presentPosition.getRankNumber(), moveSubCountExceptTargetPosition);
            }
        }

        if (MovePatternFactory.checkWidthStraight(this.presentPosition, this.targetPosition)) {
            int moveSubCount = this.presentPosition.getFileNumber() - this.targetPosition.getFileNumber();
            if (this.direction.equals(Direction.LEFT) && moveSubCount > 0) {
                int moveSubCountExceptTargetPosition = moveSubCount + 1;
                isObstruction = validObstructionOnBackRoad(chessBoard, this.presentPosition.getFile(), this.presentPosition.getRankNumber(), moveSubCountExceptTargetPosition);
            }

            if (this.direction.equals(Direction.RIGHT) && moveSubCount < 0) {
                int moveSubCountExceptTargetPosition = moveSubCount - 1;
                isObstruction = validObstructionOnFrontRoad(chessBoard, this.presentPosition.getFile(), this.presentPosition.getRankNumber(), moveSubCountExceptTargetPosition);
            }
        }

        return isObstruction;
    }

    private boolean validObstructionOnFrontRoad(ChessBoard chessBoard, File standardFile, int standardRank, int movePositionCount) {
        for (int index = movePositionCount - 1; index > 0; index--) {
            int subRankNum = standardRank - index;
            Optional<Piece> pieceByPosition = chessBoard.findPieceByPosition(Position.of(standardFile, Rank.convertNameToRank(subRankNum)));
            if (!pieceByPosition.isPresent()) {
                return false;
            }
        }

        return true;
    }

    private boolean validObstructionOnBackRoad(ChessBoard chessBoard, File standardFile, int standardRank, int movePositionCount) {
        for (int index = movePositionCount + 1; index < 0; index++) {
            int subRankNum = standardRank - index;
            Optional<Piece> pieceByPosition = chessBoard.findPieceByPosition(Position.of(standardFile, Rank.convertNameToRank(subRankNum)));
            if (!pieceByPosition.isPresent()) {
                return false;
            }
        }

        return true;
    }

    private void initDirectionAndCount(int presentNumber, int targetNumber, Direction direction) {
        int moveCount = presentNumber - targetNumber;
        setDirection(direction);
        setMoveCount(moveCount);
    }

    private boolean changeOnlyRank() {
        return (presentPosition.getFileNumber() == targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() != targetPosition.getRankNumber());
    }

    private boolean changeOnlyFile() {
        return (presentPosition.getFileNumber() != targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() == targetPosition.getRankNumber());
    }

    private boolean increaseRank() {
        return presentPosition.getRankNumber() < targetPosition.getRankNumber();
    }

    private boolean decreaseRank() {
        return presentPosition.getRankNumber() > targetPosition.getRankNumber();
    }

    private boolean increaseFile() {
        return presentPosition.getFileNumber() < targetPosition.getFileNumber();
    }

    private boolean decreaseFile() {
        return presentPosition.getFileNumber() > targetPosition.getFileNumber();
    }
}

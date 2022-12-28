package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.NoMatchMovePatternException;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
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
        int tempRankMoveCount = Math.abs(presentPosition.getRankNumber() - targetPosition.getRankNumber());
        int tempFileMoveCount = Math.abs(presentPosition.getFileNumber() - targetPosition.getFileNumber());
        if (changeOnlyRank() && increaseRank()) {
            initDirectionAndCount(tempRankMoveCount, Direction.FRONT);
            return;
        }

        if (changeOnlyRank() && decreaseRank()) {
            initDirectionAndCount(tempRankMoveCount, Direction.BACK);
            return;
        }

        if (changeOnlyFile() && increaseFile()) {
            initDirectionAndCount(tempFileMoveCount, Direction.RIGHT);
            return;
        }

        if (changeOnlyFile() && decreaseFile()) {
            initDirectionAndCount(tempFileMoveCount, Direction.LEFT);
            return;
        }

        throw new NoMatchMovePatternException();
    }

    @Override
    public void checkObstructionOnMovePath(ChessBoard chessBoard, Piece piece) {
        Position tempPosition = Position.of(this.presentPosition.getFile(), this.targetPosition.getRank());
        int moveCountExceptTargetPosition = this.moveCount - 1;
        for (int index = 0; moveCountExceptTargetPosition > index; index++) {
            checkOneStep(chessBoard, tempPosition);
        }
    }

    private void checkOneStep(ChessBoard chessBoard, Position tempPosition) {
        tempPosition.movePosition(this.direction.getXPoint(), this.direction.getYPoint());
        Optional<Piece> pieceExpectedEmpty = chessBoard.findPieceByPosition(tempPosition).filter(Piece::isNotNight);
        if (pieceExpectedEmpty.isPresent()) {
            throw new NotMoveTargetPositionException();
        }
    }

    private boolean changeOnlyRank() {
        return (presentPosition.getFileNumber() == targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() != targetPosition.getRankNumber());
    }

    private boolean changeOnlyFile() {
        return (presentPosition.getFileNumber() != targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() == targetPosition.getRankNumber());
    }
}

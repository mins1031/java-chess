package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;

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
        int presentRankNumber = presentPosition.getRankNumber();
        int presentFileNumber = presentPosition.getFileNumber();
        int targetRankNumber = targetPosition.getRankNumber();
        int targetFileNumber = targetPosition.getFileNumber();

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

    private void initDirectionAndCount(int presentNumber, int targetNumber, Direction direction) {
        int moveCount = presentNumber - targetNumber;
        setDirection(direction);
        setMoveCount(moveCount);
    }

    @Override
    public boolean checkOurPieceInMovePath(ChessBoard chessBoard) {
        if (MovePatternFactory.checkHeightStraight(this.getPresentPosition(), this.getTargetPosition())) {
            File standardFile = this.getPresentPosition().getFile();
            int presentRankNumber = this.getPresentPosition().getRankNumber();
            int targetRankNumber = this.getTargetPosition().getRankNumber();
            int movePositionCount = presentRankNumber - targetRankNumber;
        }

        return false;
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

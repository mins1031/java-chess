package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.WrongMatchCrossMovePatternException;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;

public class CrossMovePattern extends MovePattern {

    public CrossMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public void checkObstructionOnMovePath(ChessBoard chessBoard, Piece piece) {

    }

    @Override
    public void calculateMoveDirectionAndCount() {
        int tempFileMoveCount = Math.abs(this.presentPosition.getFileNumber() - this.targetPosition.getFileNumber());
        int tempRankMoveCount = Math.abs(this.presentPosition.getRankNumber() - this.targetPosition.getRankNumber());
        
        if (!isSameRankAndFileMoveCount(tempFileMoveCount, tempRankMoveCount)) {
            throw new WrongMatchCrossMovePatternException();
        }
        
        if (isRightAndFront()) {
            initDirectionAndCount(tempFileMoveCount, Direction.RIGHT_FRONT);
        }
        
        if (isLeftAndFront()) {
            initDirectionAndCount(tempFileMoveCount, Direction.LEFT_FRONT);
        }
        
        if (isRightAndBack()) {
            initDirectionAndCount(tempFileMoveCount, Direction.RIGHT_BACK);
        }
        
        if (isLeftAndBack()) {
            initDirectionAndCount(tempFileMoveCount, Direction.LEFT_BACK);
        }
    }

    private boolean isLeftAndBack() {
        return decreaseFile() && decreaseRank();
    }

    private boolean isRightAndBack() {
        return increaseFile() && decreaseRank();
    }

    private boolean isLeftAndFront() {
        return increaseRank() && decreaseFile();
    }

    private boolean isRightAndFront() {
        return increaseFile() && increaseRank();
    }

    private boolean isSameRankAndFileMoveCount(int tempFileMoveCount, int tempRankMoveCount) {
        return tempFileMoveCount == tempRankMoveCount;
    }
}

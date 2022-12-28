package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;

@Getter
public abstract class MovePattern {
    protected Position presentPosition;
    protected Position targetPosition;
    protected Direction direction;
    protected int moveCount;

    public MovePattern(Position presentPosition, Position targetPosition) {
        this.presentPosition = presentPosition;
        this.targetPosition = targetPosition;
    }

    public abstract boolean isMatchToPiece(Piece piece);

    public abstract void checkObstructionOnMovePath(ChessBoard chessBoard, Piece piece);

    public abstract void calculateMoveDirectionAndCount();

    public boolean increaseRank() {
        return presentPosition.getRankNumber() < targetPosition.getRankNumber();
    }

    public boolean decreaseRank() {
        return presentPosition.getRankNumber() > targetPosition.getRankNumber();
    }

    public boolean increaseFile() {
        return presentPosition.getFileNumber() < targetPosition.getFileNumber();
    }

    public boolean decreaseFile() {
        return presentPosition.getFileNumber() > targetPosition.getFileNumber();
    }

    public void initDirectionAndCount(int moveCount, Direction direction) {
        this.direction = direction;
        this.moveCount = moveCount;
    }
}

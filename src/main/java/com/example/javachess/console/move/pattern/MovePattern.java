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

    public abstract boolean checkObstructionOnMovePath(ChessBoard chessBoard);

    public abstract void calculateMoveDirectionAndCount();

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}

package com.example.javachess.console.move;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.piece.Piece;

public abstract class MovePattern {
    private Position presentPosition;
    private Position targetPosition;

    public MovePattern(Position presentPosition, Position targetPosition) {
        this.presentPosition = presentPosition;
        this.targetPosition = targetPosition;
    }

    public abstract boolean isMatchToPiece(Piece piece);

    public abstract boolean checkOurPieceInMovePath();
}

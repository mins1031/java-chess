package com.example.javachess.console.move;

import com.example.javachess.console.piece.Piece;

public interface MovePattern {
    public abstract boolean isMatchToPiece(Piece piece);
}

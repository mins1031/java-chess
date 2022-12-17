package com.example.javachess.console.move;

import com.example.javachess.console.piece.Piece;

public class CrossMovePattern implements MovePattern {

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return true;
    }
}

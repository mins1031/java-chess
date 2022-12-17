package com.example.javachess.console.move;

import com.example.javachess.console.piece.Piece;

public class StraightMovePattern implements MovePattern {

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return true;
    }
}

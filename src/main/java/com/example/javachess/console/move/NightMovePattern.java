package com.example.javachess.console.move;

import com.example.javachess.console.piece.Piece;

public class NightMovePattern implements MovePattern {
    public static final int NIGHT_BIG_MOVE_SPACE_COUNT = 2;
    public static final int NIGHT_SMALL_MOVE_SPACE_COUNT = 1;

    @Override
    public boolean isMatchToPiece(Piece piece) {

        return true;
    }
}

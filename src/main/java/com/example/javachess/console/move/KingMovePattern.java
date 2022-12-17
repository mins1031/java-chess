package com.example.javachess.console.move;

import com.example.javachess.console.piece.Piece;
import com.example.javachess.console.piece.PieceName;

import java.util.Arrays;
import java.util.List;

public class KingMovePattern implements MovePattern {
    public static final int KING_MOVE_SPACE_COUNT = 1;

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return false;
    }
}

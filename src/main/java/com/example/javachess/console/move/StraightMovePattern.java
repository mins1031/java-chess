package com.example.javachess.console.move;

import com.example.javachess.console.Position.Position;
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
    public boolean checkOurPieceInMovePath() {
        return false;
    }
}

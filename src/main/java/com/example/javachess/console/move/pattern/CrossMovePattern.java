package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.piece.Piece;

public class CrossMovePattern extends MovePattern {

    public CrossMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return true;
    }

    @Override
    public boolean checkObstructionOnMovePath(ChessBoard chessBoard) {
        return false;
    }

    @Override
    public void calculateMoveDirectionAndCount() {

    }
}

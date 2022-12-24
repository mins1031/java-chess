package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.piece.Piece;

public class KingMovePattern extends MovePattern {
    public static final int KING_MOVE_SPACE_COUNT = 1;

    public KingMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return false;
    }

    @Override
    public boolean checkObstructionOnMovePath(ChessBoard chessBoard) {
        return false;
    }

    @Override
    public void calculateMoveDirectionAndCount() {

    }
}

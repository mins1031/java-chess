package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.piece.Piece;

public class NightMovePattern extends MovePattern {
    public static final int NIGHT_BIG_MOVE_SPACE_COUNT = 2;
    public static final int NIGHT_SMALL_MOVE_SPACE_COUNT = 1;

    public NightMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public void checkObstructionOnMovePath(ChessBoard chessBoard) {
    }

    @Override
    public void calculateMoveDirectionAndCount() {

    }
}

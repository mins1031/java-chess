package com.example.javachess.console.move;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
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
    public boolean checkOurPieceInMovePath(ChessBoard chessBoard) {
        File standardFile = this.getPresentPosition().getFile();
        int presentRankNumber = this.getPresentPosition().getRankNumber();
        int targetRankNumber = this.getTargetPosition().getRankNumber();
        int movePositionCount = presentRankNumber - targetRankNumber;



        return false;
    }
}

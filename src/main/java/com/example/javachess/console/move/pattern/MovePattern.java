package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;

@Getter
public abstract class MovePattern {
    private Position presentPosition;
    private Position targetPosition;

    public MovePattern(Position presentPosition, Position targetPosition) {
        this.presentPosition = presentPosition;
        this.targetPosition = targetPosition;
    }

    public abstract boolean isMatchToPiece(Piece piece);

    public abstract boolean checkOurPieceInMovePath(ChessBoard chessBoard);
}

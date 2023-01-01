package com.example.javachess.console.Team;

import com.example.javachess.console.board.OutsideOfBoard;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;

import java.util.function.Consumer;

@Getter
public enum TeamType {
    BLACK((targetPiece) -> OutsideOfBoard.addDeadPieceThatBlackTeam(targetPiece)),
    WHITE((targetPiece) -> OutsideOfBoard.addDeadPieceThatWhiteTeam(targetPiece))
    ;

    private Consumer<Piece> consumer;

    TeamType(Consumer<Piece> consumer) {
        this.consumer = consumer;
    }
}

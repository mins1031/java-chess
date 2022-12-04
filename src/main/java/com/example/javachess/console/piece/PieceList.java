package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum PieceList {
    PAWN(),
    ROOK(),
    BISHOP(),
    NIGHT(),
    QUEEN(),
    KING()
    ;

    private BiFunction<Position, Team, Piece> function;
}

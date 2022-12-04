package com.example.javachess.console.piece;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import lombok.Getter;

import java.util.function.BiFunction;
import java.util.function.Function;

@Getter
public enum PieceList {
    PAWN(() -> ),
    ROOK(),
    BISHOP(),
    NIGHT(),
    QUEEN(),
    KING()
    ;

    private BiFunction<File, Rank, Piece> function;
}

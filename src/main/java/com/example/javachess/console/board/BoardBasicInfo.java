package com.example.javachess.console.board;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;

import java.util.Arrays;
import java.util.List;

public class BoardBasicInfo {

    //체스판 초기 진영별 체스줄
    public static final Integer WHITE_FIRST_INIT_LINE = 1;
    public static final Integer WHITE_SECOND_INIT_LINE = 2;

    public static final Integer BLACK_FIRST_INIT_LINE = 7;
    public static final Integer BLACK_SECOND_INIT_LINE = 8;

    public static final List<Position> INIT_WHITE_PIECE_POSITIONS = Arrays.asList(
            Position.of(File.A, Rank.ONE),
            Position.of(File.B, Rank.ONE),
            Position.of(File.C, Rank.ONE),
            Position.of(File.D, Rank.ONE),
            Position.of(File.E, Rank.ONE),
            Position.of(File.F, Rank.ONE),
            Position.of(File.G, Rank.ONE),
            Position.of(File.H, Rank.ONE)
    );

    public static final List<Position> INIT_BLACK_PIECE_POSITIONS = Arrays.asList(
            Position.of(File.A, Rank.EIGHT),
            Position.of(File.B, Rank.EIGHT),
            Position.of(File.C, Rank.EIGHT),
            Position.of(File.D, Rank.EIGHT),
            Position.of(File.E, Rank.EIGHT),
            Position.of(File.F, Rank.EIGHT),
            Position.of(File.G, Rank.EIGHT),
            Position.of(File.H, Rank.EIGHT)
    );

    public static final Rank PAWN_INIT_RIGHT_POSITION = Rank.TWO;
}

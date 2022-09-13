package com.example.javachess.console.board;

import java.util.Arrays;
import java.util.List;

public class BoardBasicInfo {

    public static final int HEIGHT_MIN_POINT = 1;
    public static final int HEIGHT_MAX_POINT = 8;
    public static final List<Integer> HEIGHT_POINTS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    public static final String WIDTH_MIN_POINT = "a";
    public static final String WIDTH_MAX_POINT = "h";
    public static final List<String> WIDTH_POINTS = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");

    //체스판 초기 진영별 체스줄
    public static final Integer WHITE_FIRST_INIT_LINE = 1;
    public static final Integer WHITE_SECOND_INIT_LINE = 2;

    public static final Integer BLACK_FIRST_INIT_LINE = 7;
    public static final Integer BLACK_SECOND_INIT_LINE = 8;
}

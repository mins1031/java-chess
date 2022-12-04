package com.example.javachess.console.Position;

import lombok.Getter;

@Getter
public enum Rank {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8)
    ;

    private final int rankNumber;

    Rank(int RankNumber) {
        this.rankNumber = RankNumber;
    }
}

package com.example.javachess.console.Position;

import lombok.Getter;

@Getter
public enum Rank {
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1)
    ;

    private final int rankNumber;

    Rank(int RankNumber) {
        this.rankNumber = RankNumber;
    }
}

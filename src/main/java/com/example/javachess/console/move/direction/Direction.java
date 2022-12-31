package com.example.javachess.console.move.direction;

import lombok.Getter;

@Getter
public enum Direction {
    RIGHT(1, 0),
    LEFT(-1, 0),
    BACK(0, -1),
    FRONT(0, 1),
    RIGHT_FRONT(1, 1),
    RIGHT_BACK(1, -1),
    LEFT_FRONT(-1, 1),
    LEFT_BACK(-1, -1),
    NIGHT_FRONT_LEFT(-1, 2),
    NIGHT_FRONT_RIGHT(1, 2),
    NIGHT_LEFT_FRONT(-2, 1),
    NIGHT_LEFT_BACK(-2, -1),
    NIGHT_RIGHT_FRONT(2, 1),
    NIGHT_RIGHT_BACK(2, -1),
    NIGHT_BACK_LEFT(-1, -2),
    NIGHT_BACK_RIGHT(1, -2)
    ;

    private int xPoint;
    private int yPoint;

    Direction(int xPoint, int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }
}

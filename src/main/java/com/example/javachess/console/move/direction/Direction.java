package com.example.javachess.console.move.direction;

public enum Direction {
    RIGHT(1, 0),
    LEFT(-1, 0),
    BACK(0, -1),
    FRONT(0, 1),
    RIGHT_FRONT(1, 1),
    RIGHT_BACK(1, -1),
    LEFT_FRONT(-1, 1),
    LEFT_BACK(-1, -1)
    ;

    private int xPoint;
    private int yPoint;

    Direction(int xPoint, int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }
}

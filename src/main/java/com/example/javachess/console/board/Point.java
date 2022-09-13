package com.example.javachess.console.board;

public class Point {

    private String xPoint;
    private int yPoint;
    private boolean standPiece;

    public Point(String xPoint, int yPoint, boolean standPiece) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.standPiece = standPiece;
    }

}

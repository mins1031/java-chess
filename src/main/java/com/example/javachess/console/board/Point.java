package com.example.javachess.console.board;

import com.example.javachess.console.piece.Piece;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Point {

    private String xPoint;
    private int yPoint;
    private Piece standPiece;

    public Point(String xPoint, int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        this.standPiece = null;
    }

    public void setStandPiece(Piece standPiece) {
        this.standPiece = standPiece;
    }
}

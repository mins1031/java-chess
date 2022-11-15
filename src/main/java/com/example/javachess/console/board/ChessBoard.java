package com.example.javachess.console.board;

import com.example.javachess.console.piece.Piece;

import java.util.Map;
import java.util.TreeMap;

public class ChessBoard {

    //2차원 배열보다는 map이 낫다. 전자는 특정위치를 찾기위해 2중포문을 돌겠지만 후자는 key값을 찾으면 되기에 시간 복잡도가 n^2 vs n 이다.
    private Map<Point, Piece> chessBoard = new TreeMap<>();

    public void initChessBoard() {
        for (Integer heightPoint : BoardBasicInfo.HEIGHT_POINTS) {
            for (String widthPoint : BoardBasicInfo.WIDTH_POINTS) {
                if (heightPoint.equals(BoardBasicInfo.))
            }
        }
    }

}

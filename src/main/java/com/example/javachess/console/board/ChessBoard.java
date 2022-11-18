package com.example.javachess.console.board;

import com.example.javachess.console.piece.Piece;
import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

@Getter
public class ChessBoard {
    //일급컬렉션에 대해 알아보고 map 보드를 전체 get 할지, 특정위치의 상황 get and 모든 위치의 상태 toString 처럼 get 하는 두개의 get 메서드 만들지?

    //2차원 배열보다는 map이 낫다. 전자는 특정위치를 찾기위해 2중포문을 돌겠지만 후자는 key값을 찾으면 되기에 시간 복잡도가 n^2 vs n 이다.
    private Map<String, Piece> chessBoard = new TreeMap<>();

    public void initChessBoard() {
        StringBuilder tempPointName = new StringBuilder();
        for (Integer heightPoint : BoardBasicInfo.HEIGHT_POINTS) {
            for (String widthPoint : BoardBasicInfo.WIDTH_POINTS) {
                tempPointName.delete(0, tempPointName.length());
                tempPointName.append(widthPoint).append(heightPoint);
                chessBoard.put(tempPointName.toString(), null);
            }
        }
    }

}

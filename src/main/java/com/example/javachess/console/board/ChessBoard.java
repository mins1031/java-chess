package com.example.javachess.console.board;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Getter
@NoArgsConstructor
public class ChessBoard {
    //일급컬렉션에 대해 알아보고 map 보드를 전체 get 할지, 특정위치의 상황 get and 모든 위치의 상태 toString 처럼 get 하는 두개의 get 메서드 만들지?

    //2차원 배열보다는 map이 낫다. 전자는 특정위치를 찾기위해 2중포문을 돌겠지만 후자는 key값을 찾으면 되기에 시간 복잡도가 n^2 vs n 이다.
    private Map<Position, Piece> chessBoard = new HashMap<>();

    public void initChessBoard() {
        makeBoard();
        
    }

    private void makeBoard() {
        for (File file : File.values()) {
            for (Rank rank : Rank.values()) {
                chessBoard.put(Position.of(file, rank), null);
            }
        }
    }

}

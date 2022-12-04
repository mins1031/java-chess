package com.example.javachess.console.board;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ChessBoard {
    //일급컬렉션에 대해 알아보고 map 보드를 전체 get 할지, 특정위치의 상황 get and 모든 위치의 상태 toString 처럼 get 하는 두개의 get 메서드 만들지?

    private List<Position> positions = new ArrayList<>();
    private List<Piece> pieces = new ArrayList<>();
    private

    public void initChessBoard() {
        makeBoardPosition();
        for (Position whitePiecePosition : BoardBasicInfo.INIT_WHITE_PIECE_POSITIONS) {

        }

    }

    private void makeBoardPosition() {
        for (File file : File.values()) {
            for (Rank rank : Rank.values()) {
                positions.add(Position.of(file, rank));
            }
        }
    }

}

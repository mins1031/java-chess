package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.WhiteTeam;
import com.example.javachess.console.board.ChessBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class StraightMovePatternTest {

    @DisplayName("직진 패턴에서 현재위치와 목적위치 사이의 피스여부를 파악한다.")
    @Test
    public void 현재위치_목적위치_장애물여부_체크() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.A, Rank.SEVEN);

        StraightMovePattern straightMovePattern = new StraightMovePattern(presentPosition, Position.of(File.C, Rank.SEVEN));
        straightMovePattern.calculateMoveDirectionAndCount();

        //when
        boolean isObstruction = straightMovePattern.checkObstructionOnMovePath(chessBoard, chessBoard.findPieceByPosition(presentPosition).get());

        //
        Assertions.assertThat(isObstruction).isTrue();
    }

}
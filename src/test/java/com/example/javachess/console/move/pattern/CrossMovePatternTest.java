package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.WhiteTeam;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.move.direction.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CrossMovePatternTest {

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 우상 방향설정 로직이 잘 동작한다.")
    @Test
    public void 현재위치_목적위치_우상_방향설정() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.F, Rank.SIX));

        //when
        crossMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(crossMovePattern.direction).isEqualTo(Direction.RIGHT_FRONT);
        Assertions.assertThat(crossMovePattern.moveCount).isEqualTo(1);
    }

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 우하 방향설정 로직이 잘 동작한다.")
    @Test
    public void 현재위치_목적위치_우하_방향설정() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.F, Rank.FOUR));

        //when
        crossMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(crossMovePattern.direction).isEqualTo(Direction.RIGHT_BACK);
        Assertions.assertThat(crossMovePattern.moveCount).isEqualTo(1);
    }

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 좌상 방향설정 로직이 잘 동작한다.")
    @Test
    public void 현재위치_목적위치_좌상_방향설정() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.D, Rank.SIX));

        //when
        crossMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(crossMovePattern.direction).isEqualTo(Direction.LEFT_FRONT);
        Assertions.assertThat(crossMovePattern.moveCount).isEqualTo(1);
    }

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 좌하 방향설정 로직이 잘 동작한다.")
    @Test
    public void 현재위치_목적위치_좌하_방향설정() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.D, Rank.FOUR));

        //when
        crossMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(crossMovePattern.direction).isEqualTo(Direction.LEFT_BACK);
        Assertions.assertThat(crossMovePattern.moveCount).isEqualTo(1);
    }

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 장애물이 있는경우 예외처리한다.")
    @Test
    public void 현재위치_목적위치_장애물_있음() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.F, Rank.EIGHT);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.D, Rank.SIX));
        crossMovePattern.calculateMoveDirectionAndCount();

        //when && then
        Assertions.assertThatThrownBy(() -> crossMovePattern.checkObstructionOnMovePath(chessBoard)).isInstanceOf(NotMoveTargetPositionException.class);
    }

    @DisplayName("크로스 패턴에서 현재위치와 목적위치 사이의 장애물이 없는경우 정상진행한다.")
    @Test
    public void 현재위치_목적위치_장애물_없음() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.SEVEN);

        CrossMovePattern crossMovePattern = new CrossMovePattern(presentPosition, Position.of(File.C, Rank.FIVE));
        crossMovePattern.calculateMoveDirectionAndCount();

        //when && then
        crossMovePattern.checkObstructionOnMovePath(chessBoard);
    }
}
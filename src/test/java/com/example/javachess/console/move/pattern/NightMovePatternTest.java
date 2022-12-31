package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.WhiteTeam;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.move.direction.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NightMovePatternTest {

    private ChessBoard chessBoard;

    @BeforeEach
    void setUp() {
        this.chessBoard = new ChessBoard();
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 전방 왼쪽 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_전방왼쪽_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.D, Rank.SEVEN));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_FRONT_LEFT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 전방 오른쪽 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_전방오른쪽_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.F, Rank.SEVEN));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_FRONT_RIGHT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 좌측 전방 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_좌측전방_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.C, Rank.SIX));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_LEFT_FRONT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 좌측후방 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_좌측후방_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.C, Rank.FOUR));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_LEFT_BACK);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 우측전방 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_우측전방_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.G, Rank.SIX));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_RIGHT_FRONT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 우측후방 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_우측후방_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.G, Rank.FOUR));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_RIGHT_BACK);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 후방좌측 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_후방좌측_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.D, Rank.THREE));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_BACK_LEFT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("나이트 패턴에서 현재위치와 목적위치 사이의 후방우측 방향설정 로직이 잘 동작한다.")
    @Test
    public void 나이트_패턴_후방우측_방향() {
        //given
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.E, Rank.FIVE);

        NightMovePattern nightMovePattern = new NightMovePattern(presentPosition, Position.of(File.F, Rank.THREE));

        //when
        nightMovePattern.calculateMoveDirectionAndCount();

        //then
        Assertions.assertThat(nightMovePattern.getDirection()).isEqualTo(Direction.NIGHT_BACK_RIGHT);
        Assertions.assertThat(nightMovePattern.getMoveCount()).isEqualTo(1);
    }
}
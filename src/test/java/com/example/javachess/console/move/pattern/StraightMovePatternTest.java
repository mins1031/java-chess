package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.WhiteTeam;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.NoMatchMovePatternException;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.piece.Piece;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;


class StraightMovePatternTest {

    @DisplayName("직진 패턴에서 현재위치와 목적위치 사이의 피스여부를 파악한다.")
    @Test
    public void 현재위치_목적위치_장애물여부_체크_있는경우() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.A, Rank.SEVEN);
        Optional<Piece> pieceByPosition = chessBoard.findPieceByPosition(presentPosition);

        StraightMovePattern straightMovePattern = new StraightMovePattern(presentPosition, Position.of(File.C, Rank.SEVEN));
        straightMovePattern.calculateMoveDirectionAndCount(pieceByPosition.get());

        //when && then
        Assertions.assertThatThrownBy(() -> straightMovePattern.checkObstructionOnMovePath(chessBoard, chessBoard.findPieceByPosition(presentPosition).get()))
                .isInstanceOf(NotMoveTargetPositionException.class);
    }

    @DisplayName("직진 패턴에서 현재위치와 목적위치 사이의 피스여부를 파악한다.")
    @Test
    public void 현재위치_목적위치_장애물여부_없는경우() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.A, Rank.SEVEN);
        Optional<Piece> pieceByPosition = chessBoard.findPieceByPosition(presentPosition);

        StraightMovePattern straightMovePattern = new StraightMovePattern(presentPosition, Position.of(File.A, Rank.FIVE));
        straightMovePattern.calculateMoveDirectionAndCount(pieceByPosition.get());

        //when && then
        straightMovePattern.checkObstructionOnMovePath(chessBoard, chessBoard.findPieceByPosition(presentPosition).get());
    }

    @DisplayName("직진 패턴이 아닌 움직임이 입력되면 예외 출력.")
    @Test
    public void 직진패턴이_아닌경우() {
        //given
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard(Arrays.asList(new WhiteTeam(), new BlackTeam()));
        Position presentPosition = Position.of(File.A, Rank.SEVEN);
        Optional<Piece> pieceByPosition = chessBoard.findPieceByPosition(presentPosition);

        StraightMovePattern straightMovePattern = new StraightMovePattern(presentPosition, Position.of(File.B, Rank.FIVE));

        //when && then
        Assertions.assertThatThrownBy(() -> straightMovePattern.calculateMoveDirectionAndCount(pieceByPosition.get()))
                .isInstanceOf(NoMatchMovePatternException.class);
    }

}
package com.example.javachess.console.board;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.move.CrossMovePattern;
import com.example.javachess.console.move.MovePattern;
import com.example.javachess.console.move.StraightMovePattern;
import com.example.javachess.console.piece.Piece;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ChessBoardTest {

    private ChessBoard chessBoard;

    @BeforeEach
    void setUp() {
        this.chessBoard = new ChessBoard();
    }

    @DisplayName("체스판이 8x8 형태로 구성되고 블랙, 화이트 팀의 말들이 초기화 된다")
    @Test
    void 체스판_초기화() {
        //given
        List<Position> initBeforePositions = chessBoard.getPositions();
        List<Piece> initBeforePieces = chessBoard.getPieces();

        int initBeforePieceCount = initBeforePositions.size();
        int initBeforePositionCount = initBeforePieces.size();

        //when
        chessBoard.initChessBoard(BoardBasicInfo.BASIC_TEAMS_IN_CHESS);

        //then
        List<Piece> initAfterPiece = this.chessBoard.getPieces();
        List<Position> initAfterPosition = this.chessBoard.getPositions();

        int initAfterPieceCount = initAfterPiece.size();
        int initAfterPositionCount = initAfterPosition.size();

        Assertions.assertThat(initBeforePositionCount).isEqualTo(0);
        Assertions.assertThat(initAfterPositionCount).isEqualTo(64);
        Assertions.assertThat(initBeforePieceCount).isEqualTo(0);
        Assertions.assertThat(initAfterPieceCount).isEqualTo(32);
    }

    @DisplayName("초기화 상태에서 체스판 출력 확인")
    @Test
    public void 체스판_초기화후_콘솔출력() {
        System.out.println("-------------before-init-------------");
        chessBoard.printCurrentChessBoard();

        chessBoard.initChessBoard(BoardBasicInfo.BASIC_TEAMS_IN_CHESS);

        System.out.println("-------------after-init-------------");
        chessBoard.printCurrentChessBoard();
    }

    @DisplayName("캐스팅 테스트")
    @Test
    public void 캐스팅테스트() {
        //given
        MovePattern movePattern = new StraightMovePattern();

        //when
        boolean rightSuperResult = (movePattern instanceof MovePattern);
        boolean rightSubResult = (movePattern instanceof StraightMovePattern);
        boolean wrongSubResult = (movePattern instanceof CrossMovePattern);

        //then
        Assertions.assertThat(rightSuperResult).isTrue();
        Assertions.assertThat(rightSubResult).isTrue();
        Assertions.assertThat(wrongSubResult).isFalse();
    }
}
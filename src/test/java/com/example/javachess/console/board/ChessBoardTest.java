package com.example.javachess.console.board;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.piece.Piece;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        Map<Position, Piece> intiBeforeBoard = chessBoard.getChessBoard();
        int initBeforeBoardSize = intiBeforeBoard.size();

        //when
        chessBoard.initChessBoard();

        //then
        Map<Position, Piece> initAfterBoard = this.chessBoard.getChessBoard();
        int initAfterBoardSize = initAfterBoard.size();

        Assertions.assertThat(initBeforeBoardSize).isEqualTo(0);
        Assertions.assertThat(initAfterBoardSize).isEqualTo(64);

        Assertions.assertThat(initAfterBoardSize).isEqualTo(64);

    }
}
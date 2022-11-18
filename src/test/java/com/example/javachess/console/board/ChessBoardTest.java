package com.example.javachess.console.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    private ChessBoard chessBoard;

    @BeforeEach
    void setUp() {
        this.chessBoard = new ChessBoard();
    }

    @Test
    @DisplayName("체스판이 초기화 된다.")
    void 체스판_초기화() {
        chessBoard.initChessBoard();
    }
}
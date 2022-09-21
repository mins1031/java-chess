package com.example.javachess.console.game;

import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.GameStatusManager;

public class Game {

    private MC chessMC;

    public Game(MC chessMC) {
        this.chessMC = chessMC;
    }

    public void startGame() {
        String startGameInput = chessMC.startGame();
        if (startGameInput.equals(GameStatusManager.END_INPUT)) {
            chessMC.completeGame();
            return;
        }

        ChessBoard chessBoard = new ChessBoard();
        chessBoard.initChessBoard();

    }


}

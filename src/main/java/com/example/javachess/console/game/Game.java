package com.example.javachess.console.game;

import com.example.javachess.console.common.GameStatusManager;
import com.example.javachess.console.common.InputProvider;

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

        initChessBoard();

    }


}

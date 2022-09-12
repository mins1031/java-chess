package com.example.javachess.console.game;

import com.example.javachess.console.common.InputHandler;

public class Game {

    private MC chessMC;

    private final static String START_INPUT = "start";
    private final static String END_INPUT = "end";

    public Game(MC chessMC) {
        this.chessMC = chessMC;
    }

    public boolean startGame() {
        chessMC.startGame();
        String startGameInput = InputHandler.isStartGame();
        if (startGameInput.equals(END_INPUT)) {
            return false;
        }

        return true;
    }

}

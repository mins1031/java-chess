package com.example.javachess.console;

import com.example.javachess.console.game.GameController;
import com.example.javachess.console.game.MC;

public class GameMain {

    public static void main(String[] args) {
        GameController game = new GameController(new MC());
        game.startGame();
    }
}

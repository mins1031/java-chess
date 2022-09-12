package com.example.javachess.console;

import com.example.javachess.console.game.Game;
import com.example.javachess.console.game.MC;

public class GameMain {

    public static void main(String[] args) {
        Game game = new Game(new MC());
        game.startGame();
    }
}

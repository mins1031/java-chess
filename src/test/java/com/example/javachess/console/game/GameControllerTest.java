package com.example.javachess.console.game;

import com.example.javachess.console.board.ChessBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    @DisplayName("게임시작 입력 값을 핸들링 할 수 있다")
    @Test
    void 게임시작_입력값_핸들링_start() {
        //given
        String input = "start";
        GameController gameController = new GameController(new ChessBoard());

        //when
//        boolean startGameResult = game.startGame();

        //then
//        Assertions.assertThat(startGameResult).isTrue();
    }
}
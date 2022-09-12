package com.example.javachess.console.game;

import com.example.javachess.console.common.ScannerUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("게임시작 입력 값을 핸들링 할 수 있다")
    @Test
    void 게임시작_입력값_핸들링_start() {
        //given
        String input = "start";
        Game game = new Game(new MC());
        ScannerUtil.setInputWithScannerForTest(input);

        //when
        boolean startGameResult = game.startGame();

        //then
        Assertions.assertThat(startGameResult).isTrue();
    }
}
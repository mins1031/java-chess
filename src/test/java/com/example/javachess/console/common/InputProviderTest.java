package com.example.javachess.console.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputProviderTest {

    @DisplayName("게임시작 입력 값을 핸들링 할 수 있다")
    @Test
    void 게임시작_입력값_핸들링_() {
        //given
        String startMessage = "start";

        //when
        String inputStartGame = InputProvider.isStartGame();

        //then
        Assertions.assertThat(inputStartGame).isEqualTo(startMessage);
    }
}
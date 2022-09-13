package com.example.javachess.console.game;

import com.example.javachess.console.common.InputProvider;

public class MC {

    private static final String GAME_START_MESSAGE = "체스 게임을 시작합니다.\n게임 시작은 start, 종료 end 명령을 입력하세요";
    private static final String GAME_COMPLETE_MESSAGE = "\n게임이 종료 되었습니다\n'status' 를 입력하여 결과를 확인하세요";


    public String startGame() {
        System.out.println(GAME_START_MESSAGE);
        return InputProvider.isStartGame();
    }

    public void completeGame() {
        System.out.println(GAME_COMPLETE_MESSAGE);
    }
}

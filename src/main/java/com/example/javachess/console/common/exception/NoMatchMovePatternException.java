package com.example.javachess.console.common.exception;

public class NoMatchMovePatternException extends RuntimeException {
    private static final String MESSAGE = "잘못된 명령입니다. 다시 입려해 주세요.";

    public NoMatchMovePatternException() {
        super(MESSAGE);
    }
}

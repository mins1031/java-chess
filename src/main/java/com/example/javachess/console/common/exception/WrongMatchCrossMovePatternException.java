package com.example.javachess.console.common.exception;

public class WrongMatchCrossMovePatternException extends RuntimeException {
    private static final String MESSAGE = "크로스 패턴이 아닙니다. 잘못된 패턴입니다.";

    public WrongMatchCrossMovePatternException() {
        super(MESSAGE);
    }
}

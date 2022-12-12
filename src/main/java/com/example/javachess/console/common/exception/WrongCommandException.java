package com.example.javachess.console.common.exception;

public class WrongCommandException extends RuntimeException {
    private static final String MESSAGE = "잘못된 커맨드입니다. 다시 요청해 주세요.";

    public WrongCommandException() {
        super(MESSAGE);
    }
}

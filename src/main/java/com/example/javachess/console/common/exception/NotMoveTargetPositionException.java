package com.example.javachess.console.common.exception;

public class NotMoveTargetPositionException extends RuntimeException {
    private static final String MESSAGE = "해당 말은 목적 칸으로 이동할수 없습니다.";

    public NotMoveTargetPositionException() {
        super(MESSAGE);
    }
}

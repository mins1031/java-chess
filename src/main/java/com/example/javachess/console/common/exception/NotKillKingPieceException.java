package com.example.javachess.console.common.exception;

public class NotKillKingPieceException extends RuntimeException {
    private static final String MESSAGE = "왕은 퀸과 왕을 잡을 수 없습니다.";

    public NotKillKingPieceException() {
        super(MESSAGE);
    }
}

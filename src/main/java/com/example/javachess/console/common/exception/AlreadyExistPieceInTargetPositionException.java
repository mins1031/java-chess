package com.example.javachess.console.common.exception;

public class AlreadyExistPieceInTargetPositionException extends RuntimeException {
    private static final String MESSAGE = "이동하려는 위치에 이미 피스가 존재합니다.";

    public AlreadyExistPieceInTargetPositionException() {
        super(MESSAGE);
    }
}

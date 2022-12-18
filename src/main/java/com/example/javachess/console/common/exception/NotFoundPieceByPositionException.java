package com.example.javachess.console.common.exception;

public class NotFoundPieceByPositionException extends RuntimeException {
    private static final String MESSAGE = "요청한 위치 정보인 체스말을 찾을수 없습니다. 잘못된 요청입니다.";

    public NotFoundPieceByPositionException() {
        super(MESSAGE);
    }
}

package com.example.javachess.console.common.exception;

public class NoAddOtherTeamPieceException extends RuntimeException {
    private static final String MESSAGE = "상대편 피스는 추가 할 수 없습니다.";

    public NoAddOtherTeamPieceException() {
        super(MESSAGE);
    }
}

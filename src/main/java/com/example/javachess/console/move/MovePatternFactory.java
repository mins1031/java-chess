package com.example.javachess.console.move;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.piece.Piece;

public class MovePatternFactory {

    public static MovePattern validationMovePattern(Piece piece, Position beforePosition, Position afterPosition) {
        if (isStraightPattern(beforePosition, afterPosition)) {
            //직진 패턴일때
            return;
        }

        if (isCrossPattern(beforePosition, afterPosition)) {
            //크로스 패턴일때
            return;
        }

        if (beforePosition.getFile().getFileNumber() != afterPosition.getFile().getFileNumber()
                && beforePosition.getRank().getRankNumber() != afterPosition.getRank().getRankNumber()) {
            //크로스 패턴일때
            return;
        }



    }

    private static boolean isCrossPattern(Position beforePosition, Position afterPosition) {
        return beforePosition.getFileNumber() != afterPosition.getFileNumber()
                && beforePosition.getRankNumber() != afterPosition.getRankNumber();
    }

    private static boolean isStraightPattern(Position beforePosition, Position afterPosition) {
        return beforePosition.getFileNumber() == afterPosition.getFileNumber()
                && beforePosition.getRankNumber() != afterPosition.getRankNumber();
    }
}

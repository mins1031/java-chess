package com.example.javachess.console.move;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;

public class MovePatternFactory {

    public static MovePattern validationMovePattern(Position beforePosition, Position afterPosition) {
        if (isStraightPattern(beforePosition, afterPosition)) {
            //직진 패턴일때
            return new StraightMovePattern();
        }

        if (isCrossPattern(beforePosition, afterPosition)) {
            //크로스 패턴일때
            return new CrossMovePattern();
        }

        if (isNightPattern(beforePosition, afterPosition)) {
            //나이트 패턴일때
            return new NightMovePattern();
        }

//        if (isStraightPattern(beforePosition, afterPosition) || isCrossPattern(beforePosition, afterPosition)) {
//            //나이트 패턴일때
//            return new KingMovePattern();
//        }

        throw new NotMoveTargetPositionException();
    }

    private static boolean isNightPattern(Position beforePosition, Position afterPosition) {
        int fileSubAbsValue = Math.abs(beforePosition.getFileNumber() - afterPosition.getFileNumber());
        int rankSubAbsValue = Math.abs(beforePosition.getRankNumber() - afterPosition.getRankNumber());

        return (fileSubAbsValue == NightMovePattern.NIGHT_BIG_MOVE_SPACE_COUNT && rankSubAbsValue == NightMovePattern.NIGHT_SMALL_MOVE_SPACE_COUNT)
                || (fileSubAbsValue == NightMovePattern.NIGHT_SMALL_MOVE_SPACE_COUNT && rankSubAbsValue == NightMovePattern.NIGHT_BIG_MOVE_SPACE_COUNT);
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

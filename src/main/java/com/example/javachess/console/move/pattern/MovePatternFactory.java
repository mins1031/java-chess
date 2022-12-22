package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;

public class MovePatternFactory {

    public static MovePattern extractMovePattern(Position presentPosition, Position targetPosition) {
        if (isNightPattern(presentPosition, targetPosition)) {
            return new NightMovePattern(presentPosition, targetPosition);
        }

        if (isStraightPattern(presentPosition, targetPosition)) {
            return new StraightMovePattern(presentPosition, targetPosition);
        }

        if (isCrossPattern(presentPosition, targetPosition)) {
            return new CrossMovePattern(presentPosition, targetPosition);
        }

        throw new NotMoveTargetPositionException();
    }

    public static boolean isStraightPattern(Position beforePosition, Position afterPosition) {
        boolean isWidthStraight = checkWidthStraight(beforePosition, afterPosition);
        boolean isHeightStraight = checkHeightStraight(beforePosition, afterPosition);

        return (isWidthStraight || isHeightStraight);
    }

    public static boolean checkHeightStraight(Position beforePosition, Position afterPosition) {
        return beforePosition.getFileNumber() != afterPosition.getFileNumber()
                && beforePosition.getRankNumber() == afterPosition.getRankNumber();
    }

    public static boolean checkWidthStraight(Position beforePosition, Position afterPosition) {
        return beforePosition.getFileNumber() == afterPosition.getFileNumber()
                && beforePosition.getRankNumber() != afterPosition.getRankNumber();
    }

    public static boolean isCrossPattern(Position beforePosition, Position afterPosition) {
        return beforePosition.getFileNumber() != afterPosition.getFileNumber()
                && beforePosition.getRankNumber() != afterPosition.getRankNumber();
    }

    public static boolean isNightPattern(Position beforePosition, Position afterPosition) {
        int fileSubAbsValue = Math.abs(beforePosition.getFileNumber() - afterPosition.getFileNumber());
        int rankSubAbsValue = Math.abs(beforePosition.getRankNumber() - afterPosition.getRankNumber());

        return (fileSubAbsValue == NightMovePattern.NIGHT_BIG_MOVE_SPACE_COUNT && rankSubAbsValue == NightMovePattern.NIGHT_SMALL_MOVE_SPACE_COUNT)
                || (fileSubAbsValue == NightMovePattern.NIGHT_SMALL_MOVE_SPACE_COUNT && rankSubAbsValue == NightMovePattern.NIGHT_BIG_MOVE_SPACE_COUNT);
    }
}

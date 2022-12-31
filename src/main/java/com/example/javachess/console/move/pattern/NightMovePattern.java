package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Night;
import lombok.Getter;

@Getter
public class NightMovePattern extends MovePattern {
    public static final int NIGHT_BIG_MOVE_SPACE_COUNT = 2;
    public static final int NIGHT_SMALL_MOVE_SPACE_COUNT = 1;

    public NightMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public void checkObstructionOnMovePath(ChessBoard chessBoard) {
    }

    @Override
    public void calculateMoveDirectionAndCount() {
        int fileSubAbsValue = Math.abs(this.presentPosition.getFileNumber() - this.targetPosition.getFileNumber());
        int rankSubAbsValue = Math.abs(this.presentPosition.getRankNumber() - this.targetPosition.getRankNumber());

        if ((decreaseFile() && increaseRank()) && isFrontOrBackMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_FRONT_LEFT);
        }

        if ((increaseFile() && increaseRank()) && isFrontOrBackMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_FRONT_RIGHT);
        }

        if ((increaseFile() && increaseRank()) && isRightOrLeftMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_RIGHT_FRONT);
        }

        if ((increaseFile() && decreaseRank()) && isRightOrLeftMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_RIGHT_BACK);
        }

        if ((decreaseFile() && increaseRank()) && isRightOrLeftMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_LEFT_FRONT);
        }

        if ((decreaseFile() && decreaseRank()) && isRightOrLeftMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_LEFT_BACK);
        }

        if ((decreaseFile() && decreaseRank()) && isFrontOrBackMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_BACK_LEFT);
        }

        if ((increaseFile() && decreaseRank()) && isFrontOrBackMove(fileSubAbsValue, rankSubAbsValue)) {
            initDirectionAndCount(Night.BASIC_MOVE_COUNT, Direction.NIGHT_BACK_RIGHT);
        }
    }

    public static boolean isFrontOrBackMove(int fileSubAbsValue, int rankSubAbsValue) {
        return fileSubAbsValue == NIGHT_SMALL_MOVE_SPACE_COUNT && rankSubAbsValue == NIGHT_BIG_MOVE_SPACE_COUNT;
    }

    public static boolean isRightOrLeftMove(int fileSubAbsValue, int rankSubAbsValue) {
        return fileSubAbsValue == NIGHT_BIG_MOVE_SPACE_COUNT && rankSubAbsValue == NIGHT_SMALL_MOVE_SPACE_COUNT;
    }
}

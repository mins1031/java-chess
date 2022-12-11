package com.example.javachess.console.common;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.command.MoveCommand;
import com.example.javachess.console.common.exception.NoMatchMovePatternException;

import java.util.Arrays;

public class StringParser {
    private static final int MOVE_COMMAND_INDEX = 0;
    private static final int BEFORE_POSITION_COMMAND_INDEX = 1;
    private static final int AFTER_POSITION_COMMAND_INDEX = 2;

    public static InputCommand commandParser(String command) {
        String[] degradedCommand = command.split(" ");
        return new InputCommand(
                extractMoveCommand(degradedCommand[MOVE_COMMAND_INDEX]),
                convertCommandToPosition(degradedCommand[BEFORE_POSITION_COMMAND_INDEX]),
                convertCommandToPosition(degradedCommand[AFTER_POSITION_COMMAND_INDEX])
        );
    }

    private static Position convertCommandToPosition(String beforePositionCommand) {
        String[] positionParts = beforePositionCommand.split("");
        return Position.of(File.convertNameToFile(positionParts[0]), Rank.convertNameToRank(Integer.parseInt(positionParts[1])));
    }

    private static MoveCommand extractMoveCommand(String anObject) {
        return Arrays.stream(MoveCommand.values())
                .filter(value -> value.getRawCommand().equals(anObject))
                .findFirst().orElseThrow(NoMatchMovePatternException::new);
    }
}

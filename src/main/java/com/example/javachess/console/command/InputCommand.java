package com.example.javachess.console.command;

import com.example.javachess.console.Position.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InputCommand {
    private MoveCommand moveCommand;
    private Position beforePosition;
    private Position afterPosition;


    public InputCommand(MoveCommand moveCommand, Position beforePosition, Position afterPosition) {
        this.moveCommand = moveCommand;
        this.beforePosition = beforePosition;
        this.afterPosition = afterPosition;
    }
}

package com.example.javachess.console.command;

import com.example.javachess.console.Position.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InputCommand {
    private MoveCommand moveCommand;
    private Position presentPosition;
    private Position targetPosition;


    public InputCommand(MoveCommand moveCommand, Position presentPosition, Position targetPosition) {
        this.moveCommand = moveCommand;
        this.presentPosition = presentPosition;
        this.targetPosition = targetPosition;
    }
}

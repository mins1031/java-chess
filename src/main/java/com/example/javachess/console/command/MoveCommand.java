package com.example.javachess.console.command;

import lombok.Getter;

@Getter
public enum MoveCommand {
    START("start"),
    MOVE("move"),
    END("end")
    ;

    private String rawCommand;

    MoveCommand(String rawCommand) {
        this.rawCommand = rawCommand;
    }
}

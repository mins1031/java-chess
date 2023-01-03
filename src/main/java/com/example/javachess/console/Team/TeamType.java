package com.example.javachess.console.Team;

import lombok.Getter;

@Getter
public enum TeamType {
    BLACK("블랙"),
    WHITE("화이트")
    ;

    private String name;

    TeamType(String name) {
        this.name = name;
    }
}

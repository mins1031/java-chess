package com.example.javachess.console.piece;

import lombok.Getter;

@Getter
public abstract class Piece {
    private Team ownTeam;

    public Piece(Team ownTeam) {
        this.ownTeam = ownTeam;
    }
}
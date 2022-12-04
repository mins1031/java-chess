package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import lombok.Getter;

@Getter
public abstract class Piece {
    private Team ownTeam;
    private Position position;

    public Piece(Team ownTeam, Position position) {
        this.ownTeam = ownTeam;
        this.position = position;
    }

    abstract boolean isInitPosition(Position position);

    public boolean isNight() {
        return false;
    }
}
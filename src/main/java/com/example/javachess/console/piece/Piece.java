package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Piece {
    private Team ownTeam;
    private Position position;

    public Piece(Team ownTeam, Position position) {
        this.ownTeam = ownTeam;
        this.position = position;
    }

    abstract boolean isInitPosition(Position position);

    public abstract String getPieceName(Team team);

    public boolean isNight() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(ownTeam, piece.ownTeam) && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownTeam, position);
    }
}
package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;

public class Bishop extends Piece {

    public Bishop(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    public static Bishop of(Team ownTeam, Position position) {
        return new Bishop(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }
}

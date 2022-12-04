package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;

public class Night extends Piece {

    public Night(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public boolean isNight() {
        return true;
    }
}

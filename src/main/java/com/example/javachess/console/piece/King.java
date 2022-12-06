package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;

public class King extends Piece {

    public King(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    public static King of(Team ownTeam, Position position){
        return new King(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }
}

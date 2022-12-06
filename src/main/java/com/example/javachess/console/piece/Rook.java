package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;

public class Rook extends Piece {

    public Rook(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    public static Rook of(Team ownTeam, Position position){
        return new Rook(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }
}

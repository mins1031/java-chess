package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;

public class Queen extends Piece {

    public Queen(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }
}

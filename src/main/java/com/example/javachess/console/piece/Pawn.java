package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import lombok.Getter;

@Getter
public class Pawn extends Piece {

    public Pawn(Team ownTeam, Position position) {
        super(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

}

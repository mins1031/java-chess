package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;

public class Night extends Piece {
    private static final String WHITE_NIGHT_NAME = "n";
    private static final String BLACK_NIGHT_NAME = "N";

    public Night(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.NIGHT);
    }

    public static Night of(Team ownTeam, Position position) {
        return new Night(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public boolean isNight() {
        return true;
    }

    @Override
    public String getPieceName(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_NIGHT_NAME;
        }
        return BLACK_NIGHT_NAME;
    }
}

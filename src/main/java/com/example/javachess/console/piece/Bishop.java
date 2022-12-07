package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;

public class Bishop extends Piece {
    private static final String WHITE_BISHOP_NAME = "b";
    private static final String BLACK_BISHOP_NAME = "B";

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

    @Override
    public String getPieceName(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_BISHOP_NAME;
        }
        return BLACK_BISHOP_NAME;
    }

}

package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;

public class King extends Piece {
    private static final String WHITE_KING_NAME = "k";
    private static final String BLACK_KING_NAME = "K";

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

    @Override
    public String getPieceName(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_KING_NAME;
        }
        return BLACK_KING_NAME;
    }
}

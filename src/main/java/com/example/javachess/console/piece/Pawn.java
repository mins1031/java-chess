package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import lombok.Getter;

@Getter
public class Pawn extends Piece {
    private static final String WHITE_PAWN_NAME = "p";
    private static final String BLACK_PAWN_NAME = "P";

    public Pawn(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.PAWN);
    }

    public static Pawn of(Team ownTeam, Position position) {
        return new Pawn(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public String getPieceName(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_PAWN_NAME;
        }
        return BLACK_PAWN_NAME;
    }


}

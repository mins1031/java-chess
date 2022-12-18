package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.MovePattern;

public class Bishop extends Piece {
    private static final String WHITE_BISHOP_NAME = "b";
    private static final String BLACK_BISHOP_NAME = "B";

    public Bishop(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.BISHOP);
    }

    public static Bishop of(Team ownTeam, Position position) {
        return new Bishop(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public boolean verifyMovePattern(MovePattern movePattern) {
        return false;
    }

    @Override
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_BISHOP_NAME;
        }
        return BLACK_BISHOP_NAME;
    }
}

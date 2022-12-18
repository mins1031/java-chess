package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.MovePattern;

public class Rook extends Piece {
    private static final String WHITE_ROOK_NAME = "r";
    private static final String BLACK_ROOK_NAME = "R";

    public Rook(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.ROOK);
    }

    public static Rook of(Team ownTeam, Position position){
        return new Rook(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_ROOK_NAME;
        }
        return BLACK_ROOK_NAME;
    }

    @Override
    public boolean verifyMovePattern(MovePattern movePattern) {
        return false;
    }
}

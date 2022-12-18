package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.CrossMovePattern;
import com.example.javachess.console.move.MovePattern;
import com.example.javachess.console.move.StraightMovePattern;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Pawn extends Piece {
    private static final String WHITE_PAWN_NAME = "p";
    private static final String BLACK_PAWN_NAME = "P";
//    private final List<MovePattern> pawnMovePatterns = Arrays.asList(new StraightMovePattern(), new CrossMovePattern());

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
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_PAWN_NAME;
        }
        return BLACK_PAWN_NAME;
    }

    @Override
    public boolean verifyMovePattern(MovePattern movePattern) {
        if (!(movePattern instanceof StraightMovePattern || movePattern instanceof CrossMovePattern)) {
            return false;
        }

        if (movePattern instanceof CrossMovePattern) {
            return true;
        }


        return true;
    }
}

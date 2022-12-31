package com.example.javachess.console.piece;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.move.pattern.CrossMovePattern;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.StraightMovePattern;
import lombok.Getter;

@Getter
public class Pawn extends Piece {
    private static final String WHITE_PAWN_NAME = "p";
    private static final String BLACK_PAWN_NAME = "P";

    private final double killedPoint = 1;

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
        if (movePattern instanceof StraightMovePattern || movePattern instanceof CrossMovePattern) {
            return true;
        }

        return false;
    }

    @Override
    public void move(Direction direction, int moveCount) {
        int xPoint = direction.getXPoint();
        int yPoint = direction.getYPoint();
        this.position = Position.of(File.convertNumToFile(xPoint), Rank.convertNameToRank(yPoint));
    }
}

package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.NightMovePattern;
import lombok.Getter;

@Getter
public class Night extends Piece {
    private static final String WHITE_NIGHT_NAME = "n";
    private static final String BLACK_NIGHT_NAME = "N";
    public static final int BASIC_MOVE_COUNT = 1;

    private final double killedPoint = 2.5;

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
    public boolean isNotNight() {
        return false;
    }

    @Override
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_NIGHT_NAME;
        }
        return BLACK_NIGHT_NAME;
    }

    @Override
    public boolean verifyMovePattern(MovePattern movePattern) {
        if (movePattern instanceof NightMovePattern) {
            return true;
        }

        return false;
    }

    @Override
    public double getPiecePoint() {
        return this.killedPoint;
    }
}

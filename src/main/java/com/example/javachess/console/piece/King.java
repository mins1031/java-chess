package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.NightMovePattern;
import lombok.Getter;

@Getter
public class King extends Piece {
    private static final String WHITE_KING_NAME = "k";
    private static final String BLACK_KING_NAME = "K";

    private final double killedPoint = 0;

    public King(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.KING);
    }

    public static King of(Team ownTeam, Position position){
        return new King(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_KING_NAME;
        }
        return BLACK_KING_NAME;
    }

    @Override
    public boolean verifyMovePattern(MovePattern movePattern) {
        if (movePattern instanceof NightMovePattern) {
            return false;
        }

        if (movePattern.getMoveCount() > 1) {
            return false;
        }

        return true;
    }

    @Override
    public double getPiecePoint() {
        return this.killedPoint;
    }
}

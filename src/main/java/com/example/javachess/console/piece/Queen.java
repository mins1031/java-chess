package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.move.pattern.CrossMovePattern;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.StraightMovePattern;

public class Queen extends Piece {
    private static final String WHITE_QUEEN_NAME = "q";
    private static final String BLACK_QUEEN_NAME = "Q";

    public Queen(Team ownTeam, Position position) {
        super(ownTeam, position, PieceName.QUEEN);
    }

    public static Queen of(Team ownTeam, Position position) {
        return new Queen(ownTeam, position);
    }

    @Override
    boolean isInitPosition(Position position) {
        return false;
    }

    @Override
    public String getPrintPieceNameByTeam(Team team) {
        if (team.getTeamType() == TeamType.WHITE) {
            return WHITE_QUEEN_NAME;
        }
        return BLACK_QUEEN_NAME;
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

    }
}

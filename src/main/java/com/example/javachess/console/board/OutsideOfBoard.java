package com.example.javachess.console.board;

import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.common.exception.NoAddOtherTeamPieceException;
import com.example.javachess.console.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class OutsideOfBoard {

    private static List<Piece> blackTeamDeadPieces = new ArrayList<>();
    private static List<Piece> whiteTeamDeadPieces = new ArrayList<>();

    public static void addDeadPieceThatBlackTeam(Piece piece) {
        if (piece.compareTeamType(TeamType.WHITE)) {
            throw new NoAddOtherTeamPieceException();
        }

        blackTeamDeadPieces.add(piece);
    }

    public static void addDeadPieceThatWhiteTeam(Piece piece) {
        if (piece.compareTeamType(TeamType.BLACK)) {
            throw new NoAddOtherTeamPieceException();
        }

        whiteTeamDeadPieces.add(piece);
    }
}

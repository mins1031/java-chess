package com.example.javachess.console.piece;

import com.example.javachess.console.Team.Team;

import java.util.List;

public class PieceInitFacade {

    public static void initWhiteTeamPiece(Team team, List<Piece> pieces) {
        List<Rook> blackRooks = team.createInitRooks();
        List<Bishop> blackBishops = team.createInitBishops();
        List<Night> blackNights = team.createInitNights();
        Queen blackQueen = team.createInitQueen();
        King blackKing = team.createInitKing();
        List<Pawn> initPawns = team.createInitPawns();

        pieces.addAll(blackRooks);
        pieces.addAll(blackBishops);
        pieces.addAll(blackNights);
        pieces.add(blackQueen);
        pieces.add(blackKing);
        pieces.addAll(blackNights);

    }

}

package com.example.javachess.console.piece;

import com.example.javachess.console.Team.Team;

import java.util.List;

public class PieceInitFacade {

    public static void initTeamPieces(Team team, List<Piece> pieces) {
        List<Rook> initTeamRooks = team.createInitRooks();
        List<Bishop> initTeamBishops = team.createInitBishops();
        List<Night> initTeamNights = team.createInitNights();
        Queen initTeamQueen = team.createInitQueen();
        King initTeamKing = team.createInitKing();
        List<Pawn> initTeamPawns = team.createInitPawns();

        pieces.addAll(initTeamRooks);
        pieces.addAll(initTeamBishops);
        pieces.addAll(initTeamNights);
        pieces.add(initTeamQueen);
        pieces.add(initTeamKing);
        pieces.addAll(initTeamPawns);
    }
}

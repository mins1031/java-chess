package com.example.javachess.console.Team;

import com.example.javachess.console.piece.Bishop;
import com.example.javachess.console.piece.King;
import com.example.javachess.console.piece.Night;
import com.example.javachess.console.piece.Pawn;
import com.example.javachess.console.piece.Queen;
import com.example.javachess.console.piece.Rook;

import java.util.List;

public abstract class Team {

    public abstract List<Rook> createInitRooks();
    public abstract List<Bishop> createInitBishops();
    public abstract List<Night> createInitNights();
    public abstract Queen createInitQueen();
    public abstract King createInitKing();
    public abstract List<Pawn> createInitPawns();
}

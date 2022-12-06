package com.example.javachess.console.Team;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.piece.Bishop;
import com.example.javachess.console.piece.King;
import com.example.javachess.console.piece.Night;
import com.example.javachess.console.piece.Pawn;
import com.example.javachess.console.piece.Queen;
import com.example.javachess.console.piece.Rook;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhiteTeam extends Team {
    private final List<Position> rookInitPosition;
    private final List<Position> bishopInitPosition;
    private final List<Position> nightInitPosition;
    private final Position queenInitPosition;
    private final Position kingInitPosition;
    private final Rank pawnInitRank;

    public WhiteTeam() {
        this.rookInitPosition = Arrays.asList(Position.of(File.A, Rank.ONE), Position.of(File.H, Rank.ONE));
        this.bishopInitPosition = Arrays.asList(Position.of(File.B, Rank.ONE), Position.of(File.G, Rank.ONE));
        this.nightInitPosition = Arrays.asList(Position.of(File.C, Rank.ONE), Position.of(File.F, Rank.ONE));
        this.queenInitPosition = Position.of(File.D, Rank.ONE);
        this.kingInitPosition = Position.of(File.E, Rank.ONE);
        this.pawnInitRank = Rank.TWO;
    }

    @Override
    public List<Rook> createInitRooks() {
        return this.rookInitPosition.stream()
                .map(position -> Rook.of(this, position))
                .collect(Collectors.toList());
    }

    @Override
    public List<Bishop> createInitBishops() {
        return this.bishopInitPosition.stream()
                .map(position -> Bishop.of(this, position))
                .collect(Collectors.toList());
    }

    @Override
    public List<Night> createInitNights() {
        return this.nightInitPosition.stream()
                .map(position -> Night.of(this, position))
                .collect(Collectors.toList());
    }

    @Override
    public Queen createInitQueen() {
        return Queen.of(this, this.queenInitPosition);
    }

    @Override
    public King createInitKing() {
        return King.of(this, this.kingInitPosition);
    }

    @Override
    public List<Pawn> createInitPawns() {
        return Arrays.stream(File.values())
                .map(file -> Position.of(file, this.pawnInitRank))
                .map(position -> Pawn.of(this, position))
                .collect(Collectors.toList());
    }
}

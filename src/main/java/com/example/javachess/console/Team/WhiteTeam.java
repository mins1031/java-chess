package com.example.javachess.console.Team;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;

import java.util.Arrays;
import java.util.List;

public class WhiteTeam extends Team {
    private final List<Position> rookInitPosition;
    private final List<Position> bishopInitPosition;
    private final List<Position> nightInitPosition;
    private final Position queenInitPosition;
    private final Position kingInitPosition;

    public WhiteTeam() {
        this.rookInitPosition = Arrays.asList(Position.of(File.A, Rank.ONE), Position.of(File.H, Rank.ONE));
        this.bishopInitPosition = Arrays.asList(Position.of(File.B, Rank.ONE), Position.of(File.G, Rank.ONE));
        this.nightInitPosition = Arrays.asList(Position.of(File.C, Rank.ONE), Position.of(File.F, Rank.ONE));
        this.queenInitPosition = Position.of(File.D, Rank.ONE);
        this.kingInitPosition = Position.of(File.E, Rank.ONE);
    }

    @Override
    boolean checkPositionIsRook(Position position) {
        return this.rookInitPosition.contains(position);
    }

    @Override
    boolean checkPositionIsBishop(Position position) {
        return this.bishopInitPosition.contains(position);
    }

    @Override
    boolean checkPositionIsNight(Position position) {
        return this.nightInitPosition.contains(position);
    }

    @Override
    boolean checkPositionIsQueen(Position position) {
        return this.queenInitPosition.equals(position);
    }

    @Override
    boolean checkPositionIsKing(Position position) {
        return this.kingInitPosition.equals(position);
    }
}

package com.example.javachess.console.Team;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;

import java.util.Arrays;
import java.util.List;

public class BlackTeam extends Team {
    private final List<Position> rookInitPosition;
    private final List<Position> bishopInitPosition;
    private final List<Position> nightInitPosition;
    private final Position queenInitPosition;
    private final Position kingInitPosition;

    public BlackTeam() {
        this.rookInitPosition = Arrays.asList(Position.of(File.A, Rank.EIGHT), Position.of(File.H, Rank.EIGHT));
        this.bishopInitPosition = Arrays.asList(Position.of(File.B, Rank.EIGHT), Position.of(File.G, Rank.EIGHT));
        this.nightInitPosition = Arrays.asList(Position.of(File.C, Rank.EIGHT), Position.of(File.F, Rank.EIGHT));
        this.queenInitPosition = Position.of(File.D, Rank.EIGHT);
        this.kingInitPosition = Position.of(File.E, Rank.EIGHT);
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

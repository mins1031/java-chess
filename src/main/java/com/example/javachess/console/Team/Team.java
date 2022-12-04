package com.example.javachess.console.Team;

import com.example.javachess.console.Position.Position;

public abstract class Team {

    abstract boolean checkPositionIsRook(Position position);

    abstract boolean checkPositionIsBishop(Position position);

    abstract boolean checkPositionIsNight(Position position);

    abstract boolean checkPositionIsQueen(Position position);

    abstract boolean checkPositionIsKing(Position position);
}

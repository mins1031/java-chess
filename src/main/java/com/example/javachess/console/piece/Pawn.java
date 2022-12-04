package com.example.javachess.console.piece;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Pawn extends Piece {
    private boolean isLive;

    public Pawn(Team ownTeam, boolean isLive) {
        super(ownTeam);
        this.isLive = isLive;
    }


}

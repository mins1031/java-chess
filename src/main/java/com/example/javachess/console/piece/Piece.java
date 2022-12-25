package com.example.javachess.console.piece;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.move.pattern.MovePattern;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Piece {
    protected Team ownTeam;
    protected Position position;
    protected PieceName pieceName;

    public Piece(Team ownTeam, Position position, PieceName pieceName) {
        this.ownTeam = ownTeam;
        this.position = position;
        this.pieceName = pieceName;
    }

    abstract boolean isInitPosition(Position position);

    public abstract String getPrintPieceNameByTeam(Team team);

    //verifyMovePattern 의 경우 패턴 뿐만 아니라 포지션 데이터도 받아야할것같다. 이걸 여기서 파리미터로 받느냐 아니면 패턴객체에 들고있냐는 고민을 해봐야 할듯.
    public abstract boolean verifyMovePattern(MovePattern movePattern);

    public abstract void move(Direction direction, int moveCount);

    public boolean isNight() {
        return false;
    }

    public boolean compareTeamType(TeamType teamType) {
        return this.ownTeam.getTeamType().equals(teamType);
    }

    public void updatePosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(ownTeam, piece.ownTeam) && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownTeam, position);
    }
}
package com.example.javachess.console.board;

import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.common.exception.NoAddOtherTeamPieceException;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameStatusBoard {

    private List<Piece> blackTeamDeadPieces;
    private List<Piece> whiteTeamDeadPieces;
    private int blackTeamDeadPoint;
    private int whiteTeamDeadPoint;
    private boolean checkMate;
    private boolean check;

    public GameStatusBoard() {
        this.blackTeamDeadPieces = new ArrayList<>();
        this.whiteTeamDeadPieces = new ArrayList<>();
        this.blackTeamDeadPoint = 0;
        this.whiteTeamDeadPoint = 0;
        this.checkMate = false;
        this.check = false;
    }

    public void addDeadPiece(Piece piece) {
        TeamType teamType = piece.getOwnTeam().getTeamType();

        if (teamType.equals(TeamType.BLACK)) {
            addDeadPieceThatBlackTeam(piece);
        }

        addDeadPieceThatWhiteTeam(piece);
    }

    private void addDeadPieceThatBlackTeam(Piece piece) {
        if (piece.compareTeamType(TeamType.WHITE)) {
            throw new NoAddOtherTeamPieceException();
        }

        blackTeamDeadPieces.add(piece);
    }

    private void addDeadPieceThatWhiteTeam(Piece piece) {
        if (piece.compareTeamType(TeamType.BLACK)) {
            throw new NoAddOtherTeamPieceException();
        }

        whiteTeamDeadPieces.add(piece);
    }

    public void plusTeamDeadPoint(TeamType teamType, double deadPoint) {
        if (teamType.equals(TeamType.BLACK)) {
            this.blackTeamDeadPoint += deadPoint;
        }

        this.whiteTeamDeadPoint += deadPoint;
    }

    public void guideGamePointEachTeam() {
        System.out.println("블랙팀 : " + this.blackTeamDeadPoint);
        System.out.println("화이트 팀 : " + this.whiteTeamDeadPoint);

        if (this.whiteTeamDeadPoint > this.blackTeamDeadPoint) {
            System.out.println("블랙팀 승리");
        }

        if (this.whiteTeamDeadPoint < this.blackTeamDeadPoint) {
            System.out.println("화이트팀 승리");
        }
    }
}

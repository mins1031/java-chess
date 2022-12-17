package com.example.javachess.console.board;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.piece.Piece;
import com.example.javachess.console.piece.PieceInitFacade;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class ChessBoard {
    private List<Position> positions = new ArrayList<>();
    private List<Piece> pieces = new ArrayList<>();
    private static final String EMPTY_POSITION = ".";

    public void initChessBoard(List<Team> teams) {
        makeBoardPosition();
        teams.forEach(team -> PieceInitFacade.initTeamPieces(team, pieces));
        printCurrentChessBoard();
    }

    public void printCurrentChessBoard() {
        for (Position position : positions) {
            String outputPosition = findPieceByPosition(position).map(piece -> piece.getTeamName(piece.getOwnTeam())).orElseGet(() -> EMPTY_POSITION);
            System.out.print(outputPosition);
            position.isFileH();
        }
    }

    public Optional<Piece> findPieceByPosition(Position position) {
        return pieces.stream()
                .filter(piece -> piece.getPosition().equals(position))
                .findFirst();
    }

    private void makeBoardPosition() {
        for (Rank rank : Rank.values()) {
            for (File file : File.values()) {
                positions.add(Position.of(file, rank));
            }
        }
    }
}

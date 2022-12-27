package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.Team.BlackTeam;
import com.example.javachess.console.Team.Team;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.NoMatchMovePatternException;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;

import java.util.Optional;

public class StraightMovePattern extends MovePattern {

    public StraightMovePattern(Position presentPosition, Position targetPosition) {
        super(presentPosition, targetPosition);
    }

    @Override
    public boolean isMatchToPiece(Piece piece) {
        return true;
    }

    @Override
    public void calculateMoveDirectionAndCount(Piece piece) {
        if (changeOnlyRank() && increaseRank(piece.getOwnTeam())) {
            initDirectionAndCount(presentPosition.getRankNumber(), targetPosition.getRankNumber(), Direction.FRONT);
            return;
        }

        if (changeOnlyRank() && decreaseRank(piece.getOwnTeam())) {
            initDirectionAndCount(presentPosition.getRankNumber(), targetPosition.getRankNumber(), Direction.BACK);
            return;
        }

        if (changeOnlyFile() && increaseFile(piece.getOwnTeam())) {
            initDirectionAndCount(presentPosition.getFileNumber(), targetPosition.getFileNumber(), Direction.RIGHT);
            return;
        }

        if (changeOnlyFile() && decreaseFile(piece.getOwnTeam())) {
            initDirectionAndCount(presentPosition.getFileNumber(), targetPosition.getFileNumber(), Direction.LEFT);
            return;
        }

        throw new NoMatchMovePatternException();
    }

    @Override
    public void checkObstructionOnMovePath(ChessBoard chessBoard, Piece piece) {
        Direction direction = this.direction;
        Position tempPosition = Position.of(this.presentPosition.getFile(), this.targetPosition.getRank());
        int moveCountExceptTargetPosition = this.moveCount - 1;
        for (int index = 0; moveCountExceptTargetPosition > index; index++) {
            tempPosition.movePosition(direction.getXPoint(), direction.getYPoint());
            Optional<Piece> pieceExpectedEmpty = chessBoard.findPieceByPosition(tempPosition).filter(Piece::isNotNight);
            if (pieceExpectedEmpty.isPresent()) {
                throw new NotMoveTargetPositionException();
            }
        }
    }

    private void initDirectionAndCount(int presentNumber, int targetNumber, Direction direction) {
        int moveCount = Math.abs(presentNumber - targetNumber);
        setDirection(direction);
        setMoveCount(moveCount);
    }

    private boolean changeOnlyRank() {
        return (presentPosition.getFileNumber() == targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() != targetPosition.getRankNumber());
    }

    private boolean changeOnlyFile() {
        return (presentPosition.getFileNumber() != targetPosition.getFileNumber())
                && (presentPosition.getRankNumber() == targetPosition.getRankNumber());
    }

    private boolean increaseRank(Team team) {
        return presentPosition.getRankNumber() < targetPosition.getRankNumber();
    }

    private boolean decreaseRank(Team team) {
        return presentPosition.getRankNumber() > targetPosition.getRankNumber();
    }

    private boolean increaseFile(Team team) {
        return presentPosition.getFileNumber() < targetPosition.getFileNumber();
    }

    private boolean decreaseFile(Team team) {
        return presentPosition.getFileNumber() > targetPosition.getFileNumber();
    }
}

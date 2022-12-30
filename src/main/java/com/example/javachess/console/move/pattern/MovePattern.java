package com.example.javachess.console.move.pattern;

import com.example.javachess.console.Position.Position;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.move.direction.Direction;
import com.example.javachess.console.piece.Piece;
import lombok.Getter;

import java.util.Optional;

@Getter
public abstract class MovePattern {
    protected Position presentPosition;
    protected Position targetPosition;
    protected Direction direction;
    protected int moveCount;

    public MovePattern(Position presentPosition, Position targetPosition) {
        this.presentPosition = presentPosition;
        this.targetPosition = targetPosition;
    }

    public void checkObstructionOnMovePath(ChessBoard chessBoard) {
        Position tempPosition = Position.of(this.presentPosition.getFile(), this.presentPosition.getRank());
        int moveCountExceptTargetPosition = this.moveCount - 1;
        for (int index = 0; moveCountExceptTargetPosition > index; index++) {
            checkOneStep(chessBoard, tempPosition);
        }
    }

    public abstract void calculateMoveDirectionAndCount();

    public boolean increaseRank() {
        return presentPosition.getRankNumber() < targetPosition.getRankNumber();
    }

    public boolean decreaseRank() {
        return presentPosition.getRankNumber() > targetPosition.getRankNumber();
    }

    public boolean increaseFile() {
        return presentPosition.getFileNumber() < targetPosition.getFileNumber();
    }

    public boolean decreaseFile() {
        return presentPosition.getFileNumber() > targetPosition.getFileNumber();
    }

    public void initDirectionAndCount(int moveCount, Direction direction) {
        this.direction = direction;
        this.moveCount = moveCount;
    }

    private void checkOneStep(ChessBoard chessBoard, Position tempPosition) {
        tempPosition.movePosition(this.direction.getXPoint(), this.direction.getYPoint());
        Optional<Piece> pieceExpectedEmpty = chessBoard.findPieceByPosition(tempPosition).filter(Piece::isNotNight);
        if (pieceExpectedEmpty.isPresent()) {
            throw new NotMoveTargetPositionException();
        }
    }
}

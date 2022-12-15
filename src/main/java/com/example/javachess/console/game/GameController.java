package com.example.javachess.console.game;

import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.board.BoardBasicInfo;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.common.StringParser;
import com.example.javachess.console.common.GameStatusManager;
import com.example.javachess.console.common.exception.AlreadyExistPieceInTargetPositionException;
import com.example.javachess.console.common.exception.WrongCommandException;
import com.example.javachess.console.move.MovePatternFactory;
import com.example.javachess.console.piece.Piece;

import java.util.Optional;

public class GameController {

    private ChessBoard chessBoard;
    private int blackTeamCycleCount;
    private int whiteTeamCycleCount;
    private TeamType presentTurn;

    public GameController(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.blackTeamCycleCount = 0;
        this.whiteTeamCycleCount = 0;
        this.presentTurn = TeamType.BLACK;
    }

    public void startGame() {
        String startGameInput = MC.startGame();
        if (startGameInput.equals(GameStatusManager.END_INPUT)) {
            MC.completeGame();
            return;
        }

        chessBoard.initChessBoard(BoardBasicInfo.BASIC_TEAMS_IN_CHESS);
        onGoingChessGame(chessBoard);
    }

    private void onGoingChessGame(ChessBoard chessBoard) {
        while (true) {
            String command = MC.requestCommand();
            try {
                InputCommand inputCommand = StringParser.commandParser(command);
                Optional<Piece> beforePiece = chessBoard.findPieceByPosition(inputCommand.getBeforePosition());
                Optional<Piece> afterPiece = chessBoard.findPieceByPosition(inputCommand.getAfterPosition());
                validPiecePositions(beforePiece, afterPiece);
                MovePatternFactory.validationMovePattern(beforePiece.get(), inputCommand.getBeforePosition(), inputCommand.getAfterPosition());


                //TODO king이 잡혔는지 아닌지 확인해줄 검증 메서드가 마지막에 필요. -> 체크메이트인지 확인후 while문 탈출
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

            changePresentTurn();
        }
    }

    private void validPiecePositions(Optional<Piece> beforePiecePosition, Optional<Piece> afterPiecePosition) {
        //이전 좌표에 현재턴인 팀의 피스가 있어야함.
        if (!beforePiecePosition.isPresent() || !isPresentTurnTeamPieceInPosition(beforePiecePosition)) {
            throw new WrongCommandException();
        }

        //목표 좌표에 현재턴인 팀의 피스가 있으면 안됨.
        if (isPresentTurnTeamPieceInPosition(afterPiecePosition)) {
            throw new AlreadyExistPieceInTargetPositionException();
        }
    }

    private boolean isPresentTurnTeamPieceInPosition(Optional<Piece> piecePosition) {
        return piecePosition.get().compareTeamType(presentTurn);
    }

    private void changePresentTurn() {
        if (this.presentTurn.equals(TeamType.BLACK)) {
            this.presentTurn = TeamType.WHITE;
        }

        if (this.presentTurn.equals(TeamType.WHITE)) {
            this.presentTurn = TeamType.BLACK;
        }
    }
}

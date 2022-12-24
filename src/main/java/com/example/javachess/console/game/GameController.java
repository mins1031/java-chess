package com.example.javachess.console.game;

import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.board.BoardBasicInfo;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.common.StringParser;
import com.example.javachess.console.common.GameStatusManager;
import com.example.javachess.console.common.exception.AlreadyExistPieceInTargetPositionException;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.common.exception.WrongCommandException;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.MovePatternFactory;
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
                InputCommand inputCommand = StringParser.inputCommandParser(command);
                movePiece(inputCommand);

                //TODO king이 잡혔는지 아닌지 확인해줄 검증 메서드가 마지막에 필요. -> 체크메이트인지 확인후 while문 탈출
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

            changePresentTurn();
        }
    }

    private void movePiece(InputCommand inputCommand) {
        // 명령을 받는다 -> 이동가능한지 파악한다. -> [해당 피스가 해당 위치로 이동이 가능한지, 목표위치에 우리팀 피스가 있는지 없는지, 이동길목에 피스가 있는지, 목표위치에 상대팀 피스가 있는지 (피스 잡음)] -> 이동
        Optional<Piece> pieceOnPresentPosition = chessBoard.findPieceByPosition(inputCommand.getPresentPosition());
        Optional<Piece> pieceOnTargetPosition = chessBoard.findPieceByPosition(inputCommand.getTargetPosition());
        validPieceInCommand(pieceOnPresentPosition, pieceOnTargetPosition);

        MovePattern movePattern = MovePatternFactory.extractMovePattern(inputCommand.getPresentPosition(), inputCommand.getTargetPosition());

        if (!pieceOnPresentPosition.get().verifyMovePattern(movePattern)) {
            throw new NotMoveTargetPositionException();
        }

        if (!pieceOnTargetPosition.isPresent() && !isPresentTurnTeamPiece(pieceOnTargetPosition)) {
            //해당 포지션 피스 제거

        }

        chessBoard.updatePiecePosition(inputCommand.getPresentPosition(), inputCommand.getTargetPosition());
    }

    private void validPieceInCommand(Optional<Piece> presentPiecePosition, Optional<Piece> targetPiecePosition) {
        //현재 좌표에 현재턴인 팀의 피스가 있어야함.
        if (!presentPiecePosition.isPresent() || !isPresentTurnTeamPiece(presentPiecePosition)) {
            throw new WrongCommandException();
        }

        //목표 좌표에 현재턴인 팀의 피스가 있으면 안됨.
        if (!targetPiecePosition.isPresent() && isPresentTurnTeamPiece(targetPiecePosition)) {
            throw new AlreadyExistPieceInTargetPositionException();
        }
    }

    private boolean isPresentTurnTeamPiece(Optional<Piece> piecePosition) {
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

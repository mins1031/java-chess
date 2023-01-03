package com.example.javachess.console.game;

import com.example.javachess.console.Team.TeamType;
import com.example.javachess.console.board.BoardBasicInfo;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.board.GameStatusBoard;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.common.OutputProvider;
import com.example.javachess.console.common.StringParser;
import com.example.javachess.console.common.GameStatusManager;
import com.example.javachess.console.common.exception.AlreadyExistPieceInTargetPositionException;
import com.example.javachess.console.common.exception.NotKillKingPieceException;
import com.example.javachess.console.common.exception.NotMoveTargetPositionException;
import com.example.javachess.console.common.exception.WrongCommandException;
import com.example.javachess.console.move.pattern.MovePattern;
import com.example.javachess.console.move.pattern.MovePatternFactory;
import com.example.javachess.console.piece.King;
import com.example.javachess.console.piece.Piece;
import com.example.javachess.console.piece.Queen;

import java.util.Optional;

public class GameController {

    private ChessBoard chessBoard;
    private GameStatusBoard gameStatusBoard;
    private TeamType presentTurn;

    public GameController(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.gameStatusBoard = new GameStatusBoard();
        this.presentTurn = TeamType.WHITE;
    }

    public void startGame() {
        String startGameInput = MC.startGame();
        if (startGameInput.equals(GameStatusManager.END_INPUT)) {
            MC.completeGame();
            return;
        }

        chessBoard.initChessBoard(BoardBasicInfo.BASIC_TEAMS_IN_CHESS);
        onGoingChessGame();
        gameStatusBoard.guideGamePointEachTeam();
    }

    public void onGoingChessGame() {
        while (true) {
            String command = MC.requestCommand();
            try {
                InputCommand inputCommand = StringParser.inputCommandParser(command);
                movePiece(inputCommand);
                if (gameStatusBoard.isCheckMate()) {
                    System.out.println("체크메이트 입니다." + this.presentTurn.getName() + "팀의 승리 입니다. 게임이 종료됩니다.");
                    break;
                }
                changePresentTurn();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            this.chessBoard.printPresentBoardStatus();
        }
    }

    private void movePiece(InputCommand inputCommand) {
        Optional<Piece> pieceOnPresentPosition = chessBoard.findPieceByPosition(inputCommand.getPresentPosition());
        Optional<Piece> pieceOnTargetPosition = chessBoard.findPieceByPosition(inputCommand.getTargetPosition());

        validPieceAsPresentTurnTeam(pieceOnPresentPosition, pieceOnTargetPosition);
        validCanMoveTargetPosition(inputCommand, pieceOnPresentPosition, pieceOnTargetPosition);
        chessBoard.movePiecePosition(inputCommand.getPresentPosition(), inputCommand.getTargetPosition());
    }

    private void validCanMoveTargetPosition(InputCommand inputCommand, Optional<Piece> pieceOnPresentPosition, Optional<Piece> pieceOnTargetPosition) {
        MovePattern movePattern = MovePatternFactory.extractMovePattern(inputCommand.getPresentPosition(), inputCommand.getTargetPosition());
        if (!pieceOnPresentPosition.get().verifyMovePattern(movePattern)) {
            throw new NotMoveTargetPositionException();
        }

        movePattern.calculateMoveDirectionAndCount();
        movePattern.checkObstructionOnMovePath(this.chessBoard);
        if (pieceOnTargetPosition.isPresent()) {
            removeTargetPiece(inputCommand, pieceOnPresentPosition, pieceOnTargetPosition);
        }
    }

    private void removeTargetPiece(InputCommand inputCommand, Optional<Piece> pieceOnPresentPosition, Optional<Piece> pieceOnTargetPosition) {
        if (isPresentTurnTeamPiece(pieceOnTargetPosition)) {
            throw new NotMoveTargetPositionException();
        }

        Piece presentPiece = pieceOnPresentPosition.get();
        Piece targetPiece = pieceOnTargetPosition.get();

        validKingRuleByKilledPiece(presentPiece, targetPiece);
        removeProcess(inputCommand, targetPiece);
    }

    private void removeProcess(InputCommand inputCommand, Piece targetPiece) {
        chessBoard.removeDeadPiece(inputCommand.getTargetPosition());
        gameStatusBoard.addDeadPiece(targetPiece);
        gameStatusBoard.plusTeamDeadPoint(targetPiece.getOwnTeam().getTeamType(), targetPiece.getPiecePoint());
    }

    private void validKingRuleByKilledPiece(Piece presentPiece, Piece targetPiece) {
        if (presentPiece instanceof King && (targetPiece instanceof Queen || targetPiece instanceof King)) {
            throw new NotKillKingPieceException();
        }
    }

    private void validPieceAsPresentTurnTeam(Optional<Piece> presentPiecePosition, Optional<Piece> targetPiecePosition) {
        //현재 좌표에 현재턴인 팀의 피스가 있어야함.
        if (!presentPiecePosition.isPresent() || !isPresentTurnTeamPiece(presentPiecePosition)) {
            throw new WrongCommandException();
        }

        //목표 좌표에 현재턴인 팀의 피스가 있으면 안됨.
        if (targetPiecePosition.isPresent() && isPresentTurnTeamPiece(targetPiecePosition)) {
            throw new AlreadyExistPieceInTargetPositionException();
        }
    }

    private boolean isPresentTurnTeamPiece(Optional<Piece> piecePosition) {
        return piecePosition.get().compareTeamType(presentTurn);
    }

    private void changePresentTurn() {
        System.out.println("차례가 변경됩니다. " + this.presentTurn);
        if (this.presentTurn.equals(TeamType.BLACK)) {
            this.presentTurn = TeamType.WHITE;
            return;
        }

        this.presentTurn = TeamType.BLACK;
    }
}

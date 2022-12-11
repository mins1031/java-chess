package com.example.javachess.console.game;

import com.example.javachess.console.board.BoardBasicInfo;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.common.StringParser;
import com.example.javachess.console.common.GameStatusManager;

public class GameController {

    private ChessBoard chessBoard;
    private int blackTeamCycleCount;
    private int whiteTeamCycleCount;

    public GameController(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.blackTeamCycleCount = 0;
        this.whiteTeamCycleCount = 0;
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

    public void onGoingChessGame(ChessBoard chessBoard) {
        while (true) {
            String command = MC.requestCommand();
            try {
                InputCommand inputCommand = StringParser.commandParser(command);
                Move
//            chessBoard.
                // king이 잡혔는지 아닌지 확인해줄 검증 메서드가 마지막에 필요. -> 체크메이트인지 확인후 while문 탈출
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package com.example.javachess.console.game;

import com.example.javachess.console.board.BoardBasicInfo;
import com.example.javachess.console.board.ChessBoard;
import com.example.javachess.console.common.InputParser;
import com.example.javachess.console.common.GameStatusManager;

public class GameController {

    private ChessBoard chessBoard;

    public GameController(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
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
                new InputParser();
//            chessBoard.
                // king이 잡혔는지 아닌지 확인해줄 검증 메서드가 마지막에 필요. -> 체크메이트인지 확인후 while문 탈출
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

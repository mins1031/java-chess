package com.example.javachess.console.common;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Rank;
import com.example.javachess.console.command.InputCommand;
import com.example.javachess.console.command.MoveCommand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @DisplayName("사용자의 명령을 입력받아 파싱한다.")
    @Test
    public void name() {
        //given
        String command = "move b2 b3";

        MoveCommand expectMoveCommand = MoveCommand.MOVE;
        File expectBeforeFile = File.B;
        Rank expectBeforeRank = Rank.TWO;

        File expectAfterFile = File.B;
        Rank expectAfterRank = Rank.THREE;

        //when
        InputCommand inputCommand = StringParser.commandParser(command);

        //then
        Assertions.assertThat(inputCommand.getMoveCommand()).isEqualTo(expectMoveCommand);
        Assertions.assertThat(inputCommand.getBeforePosition().getFile()).isEqualTo(expectBeforeFile);
        Assertions.assertThat(inputCommand.getBeforePosition().getRank()).isEqualTo(expectBeforeRank);
        Assertions.assertThat(inputCommand.getAfterPosition().getFile()).isEqualTo(expectAfterFile);
        Assertions.assertThat(inputCommand.getAfterPosition().getRank()).isEqualTo(expectAfterRank);
    }
}
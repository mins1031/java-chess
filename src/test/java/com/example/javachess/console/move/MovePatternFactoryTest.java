package com.example.javachess.console.move;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovePatternFactoryTest {

    @DisplayName("현재 위치, 이동할 위치 두개의 포지션으로 MovePattern을 구해낼 수 있다.")
    @Test
    public void MovePattern_추출() {
        //given
        Position beforePosition = Position.of(File.E, Rank.FIVE);
        Position afterPosition = Position.of(File.E, Rank.SIX);

        //when
        MovePatternFactory.validationMovePattern();

        //then

    }
}
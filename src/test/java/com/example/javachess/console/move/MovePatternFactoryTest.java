package com.example.javachess.console.move;

import com.example.javachess.console.Position.File;
import com.example.javachess.console.Position.Position;
import com.example.javachess.console.Position.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovePatternFactoryTest {

    @DisplayName("현재 위치, 이동할 위치 두개의 포지션으로 위,아래로 직진하는 StraightMovePattern을 구해낼 수 있다.")
    @Test
    public void StraightHeightMovePattern_추출() {
        //given
        Position beforePosition = Position.of(File.E, Rank.FIVE);
        Position afterPosition = Position.of(File.E, Rank.SIX);

        //when
        MovePattern movePattern = MovePatternFactory.extractMovePattern(beforePosition, afterPosition);

        //then
        Assertions.assertThat(movePattern instanceof StraightMovePattern).isTrue();
    }

    @DisplayName("현재 위치, 이동할 위치 두개의 포지션으로 좌우로 직진하는 StraightMovePattern을 구해낼 수 있다.")
    @Test
    public void StraightWidthMovePattern_추출() {
        //given
        Position beforePosition = Position.of(File.E, Rank.FIVE);
        Position afterPosition = Position.of(File.H, Rank.FIVE);

        //when
        MovePattern movePattern = MovePatternFactory.extractMovePattern(beforePosition, afterPosition);

        //then
        Assertions.assertThat(movePattern instanceof StraightMovePattern).isTrue();
    }

    @DisplayName("현재 위치, 이동할 위치 두개의 포지션으로 CrossMovePattern을 구해낼 수 있다.")
    @Test
    public void CrossMovePattern_추출() {
        //given
        Position firstBeforePosition = Position.of(File.E, Rank.FIVE);
        Position firstAfterPosition = Position.of(File.G, Rank.SEVEN);

        Position secondBeforePosition = Position.of(File.E, Rank.FIVE);
        Position secondAfterPosition = Position.of(File.C, Rank.THREE);

        //when
        MovePattern firstMovePattern = MovePatternFactory.extractMovePattern(firstBeforePosition, firstAfterPosition);
        MovePattern secondMovePattern = MovePatternFactory.extractMovePattern(secondBeforePosition, secondAfterPosition);

        //then
        Assertions.assertThat(firstMovePattern instanceof CrossMovePattern).isTrue();
        Assertions.assertThat(secondMovePattern instanceof CrossMovePattern).isTrue();
    }

    @DisplayName("현재 위치, 이동할 위치 두개의 포지션으로 NightMovePattern을 구해낼 수 있다.")
    @Test
    public void NightMovePattern_추출() {
        //given
        Position firstBeforePosition = Position.of(File.E, Rank.FIVE);
        Position firstAfterPosition = Position.of(File.D, Rank.SEVEN);

        Position secondBeforePosition = Position.of(File.E, Rank.FIVE);
        Position secondAfterPosition = Position.of(File.C, Rank.FOUR);

        //when
        MovePattern firstMovePattern = MovePatternFactory.extractMovePattern(firstBeforePosition, firstAfterPosition);
        MovePattern secondMovePattern = MovePatternFactory.extractMovePattern(secondBeforePosition, secondAfterPosition);

        //then
        Assertions.assertThat(firstMovePattern instanceof NightMovePattern).isTrue();
        Assertions.assertThat(secondMovePattern instanceof NightMovePattern).isTrue();
    }
}
package lotto.domain;

import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    @DisplayName("숫자가 6개 일치할 때 1등")
    void firstPrize() {
        //given
        int matchNumbersCount = 6;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.FIRST);
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스번호도 일치할 때 2등")
    void secondPrize() {
        //given
        int matchNumbersCount = 5;
        boolean isBonus = true;

        //when
        Prize prize = Prize.findPrize(matchNumbersCount, isBonus);

        //then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스 번호가 일치하지 않을 때 3등")
    void thirdPrize() {
        //given
        int matchNumbersCount = 5;
        boolean isBonus = false;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, isBonus))
                .isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("숫자가 4개 일치할 때 4등")
    void fourthPrize() {
        //given
        int matchNumbersCount = 4;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.FOURTH);
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("숫자가 3개 일치할 때 5등")
    void fifthPrize() {
        //given
        int matchNumbersCount = 3;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.FIFTH);
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.FIFTH);
    }

    @Test
    @DisplayName("숫자가 2개 일치할 때 꽝")
    void loseMatchesTwo() {
        //given
        int matchNumbersCount = 2;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.LOSE);
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.LOSE);
    }

    @Test
    @DisplayName("숫자가 1개 일치할 때 꽝")
    void loseMatchesOne() {
        //given
        int matchNumbersCount = 1;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.LOSE);
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.LOSE);
    }

    @Test
    @DisplayName("숫자가 0개 일치할 때 꽝")
    void lose() {
        //given
        int matchNumbersCount = 0;

        //when, then
        assertThat(Prize.findPrize(matchNumbersCount, false))
                .isEqualTo(Prize.LOSE);
        assertThat(Prize.findPrize(matchNumbersCount, true))
                .isEqualTo(Prize.LOSE);
    }
}

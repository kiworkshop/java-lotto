package lotto.constant;

import lotto.constant.PrizeCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeConditionTest {

    @Test
    @DisplayName("숫자가 6개 일치하고 보너스번호는 일치하지 않을 때 1등")
    void firstPrize() {
        //given
        int matchNumbersCount = 6;
        boolean isBonus = false;

        //when
        PrizeCondition prizeCondition = PrizeCondition.findPrize(matchNumbersCount, isBonus);

        //then
        assertThat(prizeCondition).isEqualTo(PrizeCondition.FIRST);
    }

    @Test
    @DisplayName("숫자가 6개 일치하고 보너스번호도 일치할 때 2등")
    void secondPrize() {
        //given
        int matchNumbersCount = 6;
        boolean isBonus = true;

        //when
        PrizeCondition prizeCondition = PrizeCondition.findPrize(matchNumbersCount, isBonus);

        //then
        assertThat(prizeCondition).isEqualTo(PrizeCondition.SECOND);
    }

    @Test
    @DisplayName("숫자가 5개 일치할 때 3등")
    void thirdPrize() {
        //given
        int matchNumbersCount = 5;

        //when, then
        assertThat(PrizeCondition.findPrize(matchNumbersCount, false))
                .isEqualTo(PrizeCondition.THIRD);
        assertThat(PrizeCondition.findPrize(matchNumbersCount, true))
                .isEqualTo(PrizeCondition.THIRD);
    }

    @Test
    @DisplayName("숫자가 4개 일치할 때 4등")
    void fourthPrize() {
        //given
        int matchNumbersCount = 4;

        //when, then
        assertThat(PrizeCondition.findPrize(matchNumbersCount, false))
                .isEqualTo(PrizeCondition.FOURTH);
        assertThat(PrizeCondition.findPrize(matchNumbersCount, true))
                .isEqualTo(PrizeCondition.FOURTH);
    }

    @Test
    @DisplayName("숫자가 3개 일치할 때 5등")
    void fifthPrize() {
        //given
        int matchNumbersCount = 3;

        //when, then
        assertThat(PrizeCondition.findPrize(matchNumbersCount, false))
                .isEqualTo(PrizeCondition.FIFTH);
        assertThat(PrizeCondition.findPrize(matchNumbersCount, true))
                .isEqualTo(PrizeCondition.FIFTH);
    }
}

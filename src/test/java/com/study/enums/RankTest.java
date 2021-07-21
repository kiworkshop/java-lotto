package com.study.enums;

import com.study.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("등수에 따른 상금을 반환한다.")
    void prize() throws Exception {
        int firstPrize = Rank.FIRST_PLACE.prize();
        int secondPrize = Rank.SECOND_PLACE.prize();

        assertThat(firstPrize).isEqualTo(2_000_000_000);
        assertThat(secondPrize).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName("등수에 따라 일치한 당첨번호의 개수를 반환한다.")
    void matched() throws Exception {
        int matchedForFifth = Rank.FIFTH_PLACE.matched();
        int matchedForThird = Rank.THIRD_PLACE.matched();

        assertThat(matchedForFifth).isEqualTo(3);
        assertThat(matchedForThird).isEqualTo(5);
    }

    @Test
    @DisplayName("일치한 당첨번호 수와 보너스 번호를 통해 당첨등수를 반환한다.")
    void getRank() throws Exception {
        Rank firstPlace = Rank.getRank(6, 0);
        Rank secondPlace = Rank.getRank(5, 1);
        Rank thirdPlace = Rank.getRank(5, 0);
        Rank fourthPlace = Rank.getRank(4, 0);
        Rank fifthPlace = Rank.getRank(3, 0);
        Rank etc = Rank.getRank(0, 0);

        assertThat(firstPlace).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
        assertThat(thirdPlace).isEqualTo(Rank.THIRD_PLACE);
        assertThat(fourthPlace).isEqualTo(Rank.FOURTH_PLACE);
        assertThat(fifthPlace).isEqualTo(Rank.FIFTH_PLACE);
        assertThat(etc).isEqualTo(Rank.ETC);
    }
}

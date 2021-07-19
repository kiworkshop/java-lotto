package lotto.domain;

import lotto.fixture.TestLottoSet;
import lotto.fixture.TestWinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {

    @Test
    @DisplayName("로또의 당첨 개수를 구한다")
    void testCountPrizesOfLottoSet() {
        //given
        TestLottoSet lottoSet = new TestLottoSet();
        TestWinningLotto winningLotto = new TestWinningLotto();

        //when
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto, lottoSet);
        PrizeCount prizeCount = lottoMatcher.countPrizes();

        //then
        assertThat(prizeCount.getFirst()).isEqualTo(1);
        assertThat(prizeCount.getSecond()).isEqualTo(1);
        assertThat(prizeCount.getThird()).isEqualTo(2);
        assertThat(prizeCount.getFourth()).isEqualTo(2);
        assertThat(prizeCount.getFifth()).isEqualTo(2);
    }
}

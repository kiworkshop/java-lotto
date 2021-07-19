package lotto.domain;

import lotto.fixture.TestLottoSet;
import lotto.fixture.TestWinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeCountTest {

    @Test
    @DisplayName("로또 게임의 당첨 통계를 구한다")
    void testCountPrizesOfLottoSet() {
        //given
        TestLottoSet lottoSet = new TestLottoSet();
        TestWinningLotto winningLotto = new TestWinningLotto();

        //when
        PrizeCount prizeCount = new PrizeCount(lottoSet, winningLotto);

        //then
        assertThat(prizeCount.getFirst()).isEqualTo(1);
        assertThat(prizeCount.getSecond()).isEqualTo(1);
        assertThat(prizeCount.getThird()).isEqualTo(2);
        assertThat(prizeCount.getFourth()).isEqualTo(2);
        assertThat(prizeCount.getFifth()).isEqualTo(2);
    }
}

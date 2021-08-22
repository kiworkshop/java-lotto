package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeCountTest {

    @Test
    @DisplayName("로또 여러 게임의 당첨 통계를 구한다")
    void testCountPrizesOfLottoSet() {
        //given
        TestLottoSet lottoSet = new TestLottoSet();
        TestWinningLotto winningLotto = new TestWinningLotto();

        //when
        PrizeCount prizeCount = new PrizeCount(lottoSet, winningLotto);

        //then
        assertThat(prizeCount.getPrizeCounter()[0]).isEqualTo(1);
        assertThat(prizeCount.getPrizeCounter()[1]).isEqualTo(2);
        assertThat(prizeCount.getPrizeCounter()[2]).isEqualTo(3);
        assertThat(prizeCount.getPrizeCounter()[3]).isEqualTo(4);
        assertThat(prizeCount.getPrizeCounter()[4]).isEqualTo(5);
        assertThat(prizeCount.getPrizeCounter()[5]).isEqualTo(3);
    }
}

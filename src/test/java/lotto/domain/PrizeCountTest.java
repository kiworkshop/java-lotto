package lotto.domain;

import lotto.parser.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

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
        assertThat(prizeCount.getCountFirst()).isEqualTo(1);
        assertThat(prizeCount.getCountSecond()).isEqualTo(2);
        assertThat(prizeCount.getCountThird()).isEqualTo(3);
        assertThat(prizeCount.getCountFourth()).isEqualTo(4);
        assertThat(prizeCount.getCountFifth()).isEqualTo(5);
    }
}

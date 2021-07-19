package lotto.domain;

import lotto.fixture.TestLottoSet;
import lotto.fixture.TestWinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {


    @Test
    @DisplayName("로또 구매 개수와 당첨 로또 개수를 입력받으면 수익률을 반환한다")
    void testLottoStatistics() {
        //given
        LottoMatcher lottoMatcher = new LottoMatcher(new TestWinningLotto(), new TestLottoSet());
        PrizeCount prizeCount = lottoMatcher.countPrizes();
        long prizeSum = Prize.sumOfPrizeMoney(prizeCount);
        int purchaseMoney = 18000;
        double result = (double) prizeSum / purchaseMoney;

        // when
        LottoStatistics lottoStatistics = new LottoStatistics(
                prizeCount, new PurchaseCount(purchaseMoney)
        );

        // then
        assertThat(lottoStatistics.calculateProfitRate()).isEqualTo(result);
    }
}

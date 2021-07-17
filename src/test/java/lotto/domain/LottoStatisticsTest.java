package lotto.domain;

import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private static final PrizeCount PRIZE_COUNT = new PrizeCount(new TestLottoSet(), new TestWinningLotto());
    private static final long PRIZE_SUM = Prize.sumOfPrizeMoney(PRIZE_COUNT);
    private static final int PURCHASE_MONEY = 18000;
    private static final double RESULT = (double) PRIZE_SUM / PURCHASE_MONEY;

    @Test
    @DisplayName("로또 구매 개수와 당첨 로또 개수를 입력받으면 수익률을 반환한다")
    void testLottoStatistics() {
        //given, when
        LottoStatistics lottoStatistics = new LottoStatistics(PRIZE_COUNT,
                new PurchaseCount(String.valueOf(PURCHASE_MONEY)));

        // then
        assertThat(lottoStatistics.calcProfitRate()).isEqualTo(RESULT);
    }
}

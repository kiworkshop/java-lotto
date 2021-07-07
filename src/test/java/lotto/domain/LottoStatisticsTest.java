package lotto.domain;

import lotto.constant.PrizeMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private static final PrizeCount PRIZE_COUNT = new PrizeCount(new TestLottoSet(), new TestWinningLotto());
    private static final long PRIZE_SUM = PrizeMoney.FIRST.getValue()
            + 2 * PrizeMoney.SECOND.getValue()
            + 3 * PrizeMoney.THIRD.getValue()
            + 4 * PrizeMoney.FOURTH.getValue()
            + 5 * PrizeMoney.FIFTH.getValue();
    private static final int PURCHASE_MONEY = 18000;
    private static final double RESULT = (double) PRIZE_SUM / PURCHASE_MONEY;

    @Test
    @DisplayName("당첨 로또 개수를 받으면 총 상금액을 반환한다")
    void testLottoStatistics() {
        //given, when, then
        assertThat(LottoStatistics.calcProfitRate(PRIZE_COUNT, new PurchaseCount(String.valueOf(PURCHASE_MONEY))))
                .isEqualTo(RESULT);
    }
}

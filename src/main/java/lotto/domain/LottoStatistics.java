package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;

public class LottoStatistics {

    @Getter
    PrizeCount prizeCount;
    PurchaseCount purchaseCount;

    public LottoStatistics(PrizeCount prizeCount, PurchaseCount purchaseCount) {
        this.prizeCount = prizeCount;
        this.purchaseCount = purchaseCount;
    }

    public double calculateProfitRate() {
        return (double) calculateSum() / (purchaseCount.getPurchaseCount() * Lotto.PRICE);
    }

    private long calculateSum() {
        return prizeCount.getCountFirst() * Prize.FIRST.getPrizeMoney()
                + prizeCount.getCountSecond() * Prize.SECOND.getPrizeMoney()
                + prizeCount.getCountThird() * Prize.THIRD.getPrizeMoney()
                + prizeCount.getCountFourth() * Prize.FOURTH.getPrizeMoney()
                + prizeCount.getCountFifth() * Prize.FIFTH.getPrizeMoney();
    }
}

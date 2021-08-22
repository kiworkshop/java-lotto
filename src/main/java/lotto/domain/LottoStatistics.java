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
        return prizeCount.returnEachPrizeCount(0) * Prize.FIRST.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(1) * Prize.SECOND.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(2) * Prize.THIRD.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(3) * Prize.FOURTH.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(4) * Prize.FIFTH.getPrizeMoney();
    }
}

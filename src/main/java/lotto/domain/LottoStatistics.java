package lotto.domain;

import lombok.Getter;
import lotto.constant.PrizeMoney;

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
        return prizeCount.getCountFirst() * PrizeMoney.FIRST.getValue()
                + prizeCount.getCountSecond() * PrizeMoney.SECOND.getValue()
                + prizeCount.getCountThird() * PrizeMoney.THIRD.getValue()
                + prizeCount.getCountFourth() * PrizeMoney.FOURTH.getValue()
                + prizeCount.getCountFifth() * PrizeMoney.FIFTH.getValue();
    }
}

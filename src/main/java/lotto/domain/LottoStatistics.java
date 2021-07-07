package lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lotto.constant.PrizeMoney;

public class LottoStatistics {

    @Getter
    private final PrizeCount prizeCount;
    private final PurchaseCount purchaseCount;

    @Builder
    public LottoStatistics(PrizeCount prizeCount, PurchaseCount purchaseCount) {
        this.prizeCount = prizeCount;
        this.purchaseCount = purchaseCount;
    }

    public double calcProfitRate() {
        return (double) sumOfPrizeMoney() / (purchaseCount.getPurchaseCount() * Lotto.PRICE);
    }

    private long sumOfPrizeMoney() {
        return prizeCount.getCountFirst() * PrizeMoney.FIRST.getValue()
                + prizeCount.getCountSecond() * PrizeMoney.SECOND.getValue()
                + prizeCount.getCountThird() * PrizeMoney.THIRD.getValue()
                + prizeCount.getCountFourth() * PrizeMoney.FOURTH.getValue()
                + prizeCount.getCountFifth() * PrizeMoney.FIFTH.getValue();
    }
}

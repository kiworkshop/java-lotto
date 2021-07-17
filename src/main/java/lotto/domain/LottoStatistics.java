package lotto.domain;

import lombok.Builder;
import lombok.Getter;

public class LottoStatistics {

    @Getter
    private final PrizeCount prizeCount;
    private final PurchaseCount purchaseCount;

    @Builder
    public LottoStatistics(PrizeCount prizeCount, PurchaseCount purchaseCount) {
        this.prizeCount = prizeCount;
        this.purchaseCount = purchaseCount;
    }

    public double calculateProfitRate() {
        return (double) Prize.sumOfPrizeMoney(prizeCount)
                / (purchaseCount.getPurchaseCount() * Lotto.PRICE);
    }
}
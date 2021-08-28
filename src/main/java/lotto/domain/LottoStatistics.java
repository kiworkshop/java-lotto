package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;

import java.util.Arrays;

public class LottoStatistics {

    @Getter
    PrizeCount prizeCount;
    PurchaseCount purchaseCount;
    int manualPurchaseCount;

    public LottoStatistics(PrizeCount prizeCount, PurchaseCount purchaseCount) {
        this.prizeCount = prizeCount;
        this.purchaseCount = purchaseCount;
        this.manualPurchaseCount = Arrays.stream(prizeCount.getPrizeCounter()).sum() - purchaseCount.getRandomLottoPurchaseCount();
    }

    public double calculateProfitRate() {
        int allPurchaseCount = manualPurchaseCount + purchaseCount.getRandomLottoPurchaseCount();
        return (double) calculateSum() / (allPurchaseCount * Lotto.PRICE);
    }

    private long calculateSum() {
        return prizeCount.returnEachPrizeCount(0) * Prize.FIRST.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(1) * Prize.SECOND.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(2) * Prize.THIRD.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(3) * Prize.FOURTH.getPrizeMoney()
                + prizeCount.returnEachPrizeCount(4) * Prize.FIFTH.getPrizeMoney();
    }
}

package lotto.domain;

import lotto.constant.PrizeMoney;

public class LottoStatistics {

    public static double calcProfitRate(PrizeCount prizeCount, PurchaseCount purchaseCount) {
        return (double) calcSum(prizeCount) / (purchaseCount.getPurchaseCount() * Lotto.PRICE);
    }

    private static long calcSum(PrizeCount prizeCount) {
        return prizeCount.getCountFirst() * PrizeMoney.FIRST.getValue()
                + prizeCount.getCountSecond() * PrizeMoney.SECOND.getValue()
                + prizeCount.getCountThird() * PrizeMoney.THIRD.getValue()
                + prizeCount.getCountFourth() * PrizeMoney.FOURTH.getValue()
                + prizeCount.getCountFifth() * PrizeMoney.FIFTH.getValue();
    }
}

package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.StatisticsResult;
import lotto.domain.dto.WinningLottoInput;

public class LottoService {

    public PurchaseResult purchase(PurchasePriceInput purchasePriceInput) {
        PurchaseCount purchaseCount = new PurchaseCount(purchasePriceInput.getInput());
        RandomLottoSet randomLottoSet = new RandomLottoSet(purchaseCount);

        return PurchaseResult.builder()
                .purchaseCount(purchaseCount)
                .randomLottoSet(randomLottoSet)
                .build();
    }

    public StatisticsResult calculateResult(PurchaseResult purchaseResult, WinningLottoInput winningLottoInput) {
        WinningLotto winningLotto = WinningLotto.builder()
                .winningLottoInput(winningLottoInput)
                .build();
        PrizeCount prizeCount = PrizeCount.builder()
                .lottoset(purchaseResult.getRandomLottoSet())
                .winningLotto(winningLotto)
                .build();
        LottoStatistics lottoStatistics = LottoStatistics.builder()
                .prizeCount(prizeCount)
                .purchaseCount(purchaseResult.getPurchaseCount())
                .build();

        return StatisticsResult.builder()
                .prizeCount(prizeCount)
                .profitRate(lottoStatistics.calculateProfitRate())
                .build();
    }
}

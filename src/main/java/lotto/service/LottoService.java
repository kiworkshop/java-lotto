package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.StatisticsResult;
import lotto.domain.dto.WinningLottoInput;

public class LottoService {

    public PurchaseResult purchase(PurchasePriceInput purchasePriceInput) {
        PurchaseCount purchaseCount = new PurchaseCount(purchasePriceInput.getPrice());
        LottoSet lottoSet = new LottoSet(purchaseCount);

        return PurchaseResult.builder()
                .purchaseCount(purchaseCount)
                .lottoSet(lottoSet)
                .build();
    }

    public StatisticsResult calculateResult(PurchaseResult purchaseResult, WinningLottoInput winningLottoInput) {
        WinningLotto winningLotto = WinningLotto.builder()
                .winningLottoInput(winningLottoInput)
                .build();
        PrizeCount prizeCount = PrizeCount.builder()
                .lottoset(purchaseResult.getLottoSet())
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

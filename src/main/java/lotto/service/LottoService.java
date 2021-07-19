package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.LottoResult;
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

    public LottoResult calculateResult(PurchaseResult purchaseResult, WinningLottoInput winningLottoInput) {
        LottoMatcher lottoMatcher = new LottoMatcher(
                new WinningLotto(winningLottoInput), purchaseResult.getLottoSet()
        );
        PrizeCount prizeCount = lottoMatcher.countPrizes();
        LottoStatistics lottoStatistics = new LottoStatistics(prizeCount, purchaseResult.getPurchaseCount());

        return LottoResult.builder()
                .prizeCount(prizeCount)
                .profitRate(lottoStatistics.calculateProfitRate())
                .build();
    }
}

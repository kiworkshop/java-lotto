package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.LottoResult;
import lotto.domain.dto.PurchaseInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.WinningLottoInput;

public class LottoService {

    public PurchaseResult purchase(PurchaseInput purchaseInput) throws IllegalArgumentException {
        PurchaseCount purchaseCount = new PurchaseCount(purchaseInput.getPrice());
        LottoSet lottoSet = new LottoSet(purchaseCount);

        return PurchaseResult.builder()
                .purchaseCount(purchaseCount)
                .lottoSet(lottoSet)
                .build();
    }

    public LottoResult calculateResult(PurchaseResult purchaseResult, WinningLottoInput winningLottoInput) throws IllegalArgumentException {
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

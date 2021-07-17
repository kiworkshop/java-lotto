package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.StatisticsResultDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.PurchaseResultDTO;
import lotto.domain.dto.WinningLottoInputDTO;

public class LottoService {

    public PurchaseResultDTO purchase(PurchasePriceInputDTO purchasePriceInputDTO) {
        PurchaseCount purchaseCount = new PurchaseCount(purchasePriceInputDTO.getInput());
        RandomLottoSet randomLottoSet = new RandomLottoSet(purchaseCount);

        return PurchaseResultDTO.builder()
                .purchaseCount(purchaseCount)
                .randomLottoSet(randomLottoSet)
                .build();
    }

    public StatisticsResultDTO calculateResult(PurchaseResultDTO purchaseResultDTO, WinningLottoInputDTO winningLottoInputDTO) {
        WinningLotto winningLotto = WinningLotto.builder()
                .winningNumberInput(winningLottoInputDTO.getWinningLottoNumbers())
                .bonusNumberInput(winningLottoInputDTO.getWinningLottoBonus())
                .build();
        PrizeCount prizeCount = PrizeCount.builder()
                .lottoset(purchaseResultDTO.getRandomLottoSet())
                .winningLotto(winningLotto)
                .build();
        LottoStatistics lottoStatistics = LottoStatistics.builder()
                .prizeCount(prizeCount)
                .purchaseCount(purchaseResultDTO.getPurchaseCount())
                .build();

        return StatisticsResultDTO.builder()
                .prizeCount(prizeCount)
                .profitRate(lottoStatistics.calculateProfitRate())
                .build();
    }
}

package lotto.controller;

import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.PurchaseResultDTO;
import lotto.domain.dto.StatisticsResultDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {

    private final View view;
    private final LottoService lottoService;

    public LottoController(View view) {
        this.view = view;
        this.lottoService = new LottoService();
    }

    public void start() throws IllegalArgumentException {
        try {
            PurchasePriceInputDTO purchasePriceInputDTO = view.getPurchaseCost();
            PurchaseResultDTO purchaseResultDTO = lottoService.purchase(purchasePriceInputDTO);
            view.printLottoPurchaseResult(purchaseResultDTO);

            WinningLottoInputDTO winningLottoInputDTO = view.getWinningLottoAndBonus();
            StatisticsResultDTO statisticsResultDTO = lottoService.calculateResult(purchaseResultDTO, winningLottoInputDTO);
            view.printLottoStatistics(statisticsResultDTO);
        } catch (IllegalArgumentException e) {
            view.printException(e.getMessage());
        }
    }
}

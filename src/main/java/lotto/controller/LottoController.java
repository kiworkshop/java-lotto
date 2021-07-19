package lotto.controller;

import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.StatisticsResult;
import lotto.domain.dto.WinningLottoInput;
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
            PurchasePriceInput purchasePriceInput = view.getPurchaseCost();
            PurchaseResult purchaseResult = lottoService.purchase(purchasePriceInput);
            view.printLottoPurchaseResult(purchaseResult);

            WinningLottoInput winningLottoInput = view.getWinningLottoAndBonus();
            StatisticsResult statisticsResult = lottoService.calculateResult(purchaseResult, winningLottoInput);
            view.printLottoStatistics(statisticsResult);
        } catch (NumberFormatException e) {
            view.printException(e.getMessage());
        } catch (IllegalArgumentException e) {
            view.printException(e.getMessage());
        }
    }
}

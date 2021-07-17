package lotto.controller;

import lotto.domain.dto.StatisticsResultDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.PurchaseResultDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.service.LottoService;
import lotto.view.View;

public class LottoController {

    private static final View view = new View();
    private static final LottoService lottoService = new LottoService();

    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            view.printException(e.getMessage());
        }
    }

    public static void start() throws IllegalArgumentException {
        PurchasePriceInputDTO purchasePriceInputDTO = view.getPurchaseCost();
        PurchaseResultDTO purchaseResultDTO = lottoService.purchase(purchasePriceInputDTO);
        view.printLottoPurchaseResult(purchaseResultDTO);

        WinningLottoInputDTO winningLottoInputDTO = view.getWinningLottoAndBonus();
        StatisticsResultDTO statisticsResultDTO = lottoService.calculateResult(purchaseResultDTO, winningLottoInputDTO);
        view.printLottoStatistics(statisticsResultDTO);
    }
}

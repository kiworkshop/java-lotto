package lottogame.controller;

import lottogame.domain.LottoTickets;
import lottogame.domain.MoneyAmount;
import lottogame.service.LottoGameService;
import lottogame.view.InputView;

public class LottoGameController {

    private final InputView inputView;
    private final LottoGameService lottoGameService = new LottoGameService();

    public LottoGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        int moneyAmountInput = inputView.getMoneyAmountInput();
        MoneyAmount moneyAmount = lottoGameService.getMoneyAmount(moneyAmountInput);

        int lottoCount = lottoGameService.getLottoCount(moneyAmount);

        LottoTickets lottoTickets = lottoGameService.generateLottoTickets(lottoCount);
    }
}

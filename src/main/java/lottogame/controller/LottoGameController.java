package lottogame.controller;

import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.MoneyAmount;
import lottogame.service.LottoGameService;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService = new LottoGameService();

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int moneyAmountInput = inputView.getMoneyAmountInput();
        MoneyAmount moneyAmount = lottoGameService.getMoneyAmount(moneyAmountInput);

        int lottoCount = lottoGameService.getLottoCount(moneyAmount);

        LottoTickets lottoTickets = lottoGameService.generateLottoTickets(lottoCount);

        outputView.printLottoCount(lottoCount);
        outputView.printLottoTickets(lottoTickets);

    }
}

package lottogame.controller;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.MoneyAmount;
import lottogame.domain.statistics.WinningStatistics;
import lottogame.service.AutoLottoService;
import lottogame.service.UserLottoService;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserLottoService userLottoService = new UserLottoService();
    private final AutoLottoService autoLottoService = new AutoLottoService();

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int moneyAmountInput = inputView.getMoneyAmountInput();
        MoneyAmount moneyAmount = getMoneyAmount(moneyAmountInput);

        int lottoCount = getLottoCount(moneyAmount);

        LottoTickets lottoTickets = autoLottoService.generateLottoTickets(lottoCount);

        outputView.printLottoCount(lottoCount);
        outputView.printLottoTickets(lottoTickets);

        String lottoResultInput = inputView.getLottoResultInput();
        LottoTicket lottoResult = userLottoService.generateLottoTicket(lottoResultInput);

        WinningStatistics winningStatistics = userLottoService.generateWinningStatistics(lottoTickets, lottoResult);
        double earningRate = userLottoService.computeEarningRate(winningStatistics);

        outputView.printWinningStatistics(winningStatistics);
        outputView.printEarningRate(earningRate);
    }

    private MoneyAmount getMoneyAmount(int input) {
        return new MoneyAmount(input);
    }

    private int getLottoCount(MoneyAmount moneyAmount) {
        return moneyAmount.calculateLottoCount();
    }
}

package lottogame.controller;

import lottogame.domain.MoneyAmount;
import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.winninglotto.WinningLottos;
import lottogame.service.AutoLottoService;
import lottogame.service.ManualLottoService;
import lottogame.service.WinningLottoService;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ManualLottoService manualLottoService = new ManualLottoService();
    private final AutoLottoService autoLottoService = new AutoLottoService();
    private final WinningLottoService winningLottoService = new WinningLottoService();

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        MoneyAmount moneyAmount = moneyAmount();

        int totalLottoCount = getLottoCount(moneyAmount);

        LottoTickets lottoTickets = autoLottoService.generateLottoTickets(totalLottoCount);

        outputView.printLottoCount(totalLottoCount);
        outputView.printLottoTickets(lottoTickets);

        LottoTicket lottoResult = lottoResult();

        WinningLottos winningLottos = winningLottoService.generateWinningStatistics(lottoTickets, lottoResult);
        double earningRate = winningLottoService.computeEarningRate(winningLottos);

        outputView.printWinningStatistics(winningLottos);
        outputView.printEarningRate(earningRate);
    }

    private MoneyAmount moneyAmount() {
        int moneyAmountInput = inputView.getMoneyAmountInput();
        return getMoneyAmount(moneyAmountInput);
    }

    private LottoTicket lottoResult() {
        String lottoResultInput = inputView.getLottoResultInput();
        return manualLottoService.generateLottoTicket(lottoResultInput);
    }

    private MoneyAmount getMoneyAmount(int input) {
        return new MoneyAmount(input);
    }

    private int getLottoCount(MoneyAmount moneyAmount) {
        return moneyAmount.calculateLottoCount();
    }
}

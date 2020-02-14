package lottogame.controller;

import lottogame.domain.LottoCount;
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

        int totalLottoCount = LottoCount.calculateTotalLottoCount(moneyAmount).getLottoCount();
        int manualLottoCount = getManualLottoCount(totalLottoCount).getLottoCount();
        int autoLottoCount = getAutoLottoCount(totalLottoCount, manualLottoCount).getLottoCount();

        LottoTickets manualLottoTickets = manualLottoService.generateLottoTickets(manualLottoNumbers(manualLottoCount));
        LottoTickets autoLottoTickets = autoLottoService.generateLottoTickets(autoLottoCount);
        LottoTickets lottoTickets = autoLottoTickets;
        //LottoTickets lottoTickets = LottoTickets.joinLottoTickets(manualLottoTickets, autoLottoTickets);

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
        return new MoneyAmount(moneyAmountInput);
    }

    private LottoCount getManualLottoCount(int totalLottoCount) {
        int manualLottoCount = inputView.getManualLottoCount();
        return LottoCount.createLottoCount(manualLottoCount, totalLottoCount);
    }

    private LottoCount getAutoLottoCount(int totalLottoCount, int manualLottoCount) {
        return LottoCount.createLottoCount(totalLottoCount - manualLottoCount);
    }

    private String[] manualLottoNumbers(int manualLottoCount) {
        return inputView.getManualLottoNumbers(manualLottoCount);
    }

    private LottoTicket lottoResult() {
        String lottoResultInput = inputView.getLottoResultInput();
        return manualLottoService.generateLottoTicket(lottoResultInput);
    }
}

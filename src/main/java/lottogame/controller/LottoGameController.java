package lottogame.controller;

import lottogame.domain.BonusNumber;
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
        MoneyAmount moneyAmount = getMoneyAmount();

        int totalLottoCount = LottoCount.calculateTotalLottoCount(moneyAmount).getLottoCount();
        int manualLottoCount = getManualLottoCount(totalLottoCount).getLottoCount();
        int autoLottoCount = getAutoLottoCount(totalLottoCount, manualLottoCount).getLottoCount();

        String[] manualLottoNumbers = getManualLottoNumbers(manualLottoCount);
        LottoTickets manualLottoTickets = manualLottoService.generateLottoTickets(manualLottoNumbers);
        LottoTickets autoLottoTickets = autoLottoService.generateLottoTickets(autoLottoCount);
        LottoTickets lottoTickets = LottoTickets.joinLottoTickets(manualLottoTickets, autoLottoTickets);

        outputView.printLottoCount(manualLottoCount, autoLottoCount);
        outputView.printLottoTickets(lottoTickets);

        LottoTicket lottoResult = getlottoResult();
        int bonusNumber = getBonusNumber(lottoResult).getBonusNumber();

        WinningLottos winningLottos = winningLottoService.generateWinningStatistics(lottoTickets, lottoResult);
        double earningRate = winningLottoService.computeEarningRate(winningLottos);

        outputView.printWinningStatistics(winningLottos);
        outputView.printEarningRate(earningRate);
    }

    private MoneyAmount getMoneyAmount() {
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

    private String[] getManualLottoNumbers(int manualLottoCount) {
        return inputView.getManualLottoNumbers(manualLottoCount);
    }

    private LottoTicket getlottoResult() {
        String lottoResultInput = inputView.getLottoResultInput();
        return manualLottoService.generateLottoTicket(lottoResultInput);
    }

    private BonusNumber getBonusNumber(LottoTicket lottoResult) {
        int bonusNumber = inputView.getBonusNumber();
        return BonusNumber.create(bonusNumber, lottoResult);
    }
}

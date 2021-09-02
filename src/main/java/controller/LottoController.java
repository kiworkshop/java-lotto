package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    private static InputView inputView;
    private static OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = inputView.inputMoney();
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        LottoMachine lottoMachine = new LottoMachine(money);
        List<LottoTicket> purchasedLottoTickets = lottoMachine.buyLottoTickets();
        outputView.printLottoTickets(purchasedLottoTickets);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.getLottoResult(purchasedLottoTickets, winningLotto);
        outputView.printLottoResult(lottoResult);

        double profitRate = lottoResult.getProfitRate(money, lottoResult.getLottoResult());
        outputView.printStatistics(profitRate);

    }
}

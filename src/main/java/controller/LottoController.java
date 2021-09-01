package controller;

import domain.LottoMachine;
import domain.LottoTicket;
import domain.PurchaseMoney;
import domain.WinningLotto;
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

//        List<WinningLotto> lottoResult = lottoMachine.getRankResult(purchasedLottoTickets, winningNumbers, bonusNumber);
//        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoResult);
//        outputView.printRankResult(rankResult);
//        outputView.printStatistics(lottoMachine.getProfitRate(money, rankResult));

    }
}

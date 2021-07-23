package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoNumber;
import domain.PurchaseMoney;
import enums.Rank;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        outputView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall(winningNumbers);

        List<Lotto> lottoResult = lottoMachine.getRankResult(lottoTickets, winningNumbers, bonusNumber);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoResult);
        outputView.printRankResult(rankResult);
        outputView.printStatistics(lottoMachine.getProfitRate(money, rankResult));

    }
}

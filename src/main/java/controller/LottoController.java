package controller;

import domain.Lotto;
import domain.LottoMachine;
import enums.Rank;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();


    public static void main(String[] args) {
        String money = inputView.inputMoney();
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTickets = lottoMachine.getLottoTickets();
        outputView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusBall(winningNumbers);

        List<Lotto> lottoResult = lottoMachine.getRankResult(lottoTickets, winningNumbers, bonusNumber);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoResult);
        outputView.printRankResult(rankResult);
        outputView.printStatistics(lottoMachine.getProfitRate(rankResult));
    }
}

package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.Lottos;
import enums.Rank;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine(inputView.inputMoney());
        Lottos lottos= new Lottos(lottoMachine.getLottoTickets());
        outputView.printLottoTickets(lottos);

        List<Integer> winningNumbers = lottoMachine.getWinningNumber(inputView.inputWinningNumbers());
        int bonusNumber = lottoMachine.getBonusBall(inputView.inputBonusBall(), winningNumbers);

        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottos, winningNumbers, bonusNumber);
        outputView.printRankResult(rankResult);
        outputView.printStatistics(lottoMachine.getProfitRate(rankResult));
    }
}

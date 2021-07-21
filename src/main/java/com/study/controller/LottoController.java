package com.study.controller;

import com.study.domain.LottoMachine;
import com.study.domain.Lottos;
import com.study.enums.Rank;
import com.study.view.InputView;
import com.study.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine(inputView.inputMoney(), inputView.manualTicketCount());
        List<List<Integer>> manulLottos = inputView.manualLottlNumbers(lottoMachine.getLottoManualTicketCount());
        Lottos lottos = new Lottos(lottoMachine.getLottoTotalTickets(manulLottos));
        outputView.printLottoTickets(lottos);

        List<Integer> winningNumbers = lottoMachine.getWinningNumber(inputView.inputWinningNumbers());
        int bonusNumber = lottoMachine.getBonusBall(inputView.inputBonusBall(), winningNumbers);

        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottos, winningNumbers, bonusNumber);
        outputView.printRankResult(rankResult);
        outputView.printStatistics(lottoMachine.getProfitRate(rankResult));
    }
}

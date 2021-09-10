package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = inputView.inputMoney();
        int manualTicketCount = inputView.inputManualTicketCount();

        PurchaseMoney purchaseMoney = new PurchaseMoney(money);
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, manualTicketCount);

        List<List<Integer>> manualTicketNumbers = inputView.inputManualNumbers(manualTicketCount);

        List<LottoTicket> manualTickets = lottoMachine.buyManualTickets(manualTicketNumbers);
        List<LottoTicket> autoTickets = lottoMachine.buyAutoTickets();

        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        purchasedLottoTickets.addAll(manualTickets);
        purchasedLottoTickets.addAll(autoTickets);

        outputView.printLottoTickets(purchasedLottoTickets);

        LottoTicket lastWeekWinningTicket = new LottoTicket(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusBall());
        WinningLotto winningLotto = new WinningLotto(lastWeekWinningTicket, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(purchasedLottoTickets, winningLotto);
        outputView.printLottoResult(lottoResult);

        double profitRate = lottoResult.getProfitRate(purchaseMoney);
        outputView.printStatistics(profitRate);

    }
}

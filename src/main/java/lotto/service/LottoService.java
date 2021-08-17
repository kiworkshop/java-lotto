package lotto.service;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private final LottoTicketVendingMachine vendingMachine;

    public LottoService() {
        this.vendingMachine = new LottoTicketVendingMachine();
    }

    public LottoTickets issueTickets(int autoTicketAmount, List<List<Integer>> manualNumbers) {
        return vendingMachine.issueTickets(autoTicketAmount, manualNumbers);
    }

    public float getProfitRate(int totalTicketAmount, WinningLottoRank winningLottoRank) {
        WinningStatistics winningStatistics = new WinningStatistics(winningLottoRank);
        return winningStatistics.profitRate(totalTicketAmount);
    }

    public WinningLottoRank getWinningLottoRank(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
        OutputView.printWinningStatistics(winningLottoRank);
        return winningLottoRank;
    }
}

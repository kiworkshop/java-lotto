package lotto.service;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private final LottoTicketVendingMachine lottoTicketVendingMachine;

    public LottoService() {
        this.lottoTicketVendingMachine = new LottoTicketVendingMachine();
    }
    public LottoTickets issueTickets(TicketAmount ticketAmount, List<String> inputManualNumbers) {
        return lottoTicketVendingMachine.issueTickets(ticketAmount, inputManualNumbers);
    }

    public float getProfitRate(TicketAmount ticketAmount, WinningLottoRank winningLottoRank) {
        WinningStatistics winningStatistics = new WinningStatistics(winningLottoRank);
        float profitRate = winningStatistics.profitRate(ticketAmount);
        return profitRate;
    }

    public WinningLottoRank getWinningLottoRank(LottoTickets lottoTickets, List<Integer> splitWinningNumbers) {
        int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(splitWinningNumbers, bonusNumber);
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
        OutputView.printWinningStatistics(winningLottoRank);
        return winningLottoRank;
    }
}

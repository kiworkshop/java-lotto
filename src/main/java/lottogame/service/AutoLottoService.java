package lottogame.service;

import lottogame.domain.MoneyAmount;
import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.statistics.WinningStatistics;

public class AutoLottoService {

    public MoneyAmount getMoneyAmount(int input) {
        return new MoneyAmount(input);
    }

    public int getLottoCount(MoneyAmount moneyAmount) {
        return moneyAmount.calculateLottoCount();
    }

    public LottoTickets generateLottoTickets(int lottoCount) {
        return LottoTickets.with(lottoCount);
    }

    public LottoTicket generateLottoTicket(String lottoNumbersString) {
        return LottoTicket.of(lottoNumbersString);
    }

    public WinningStatistics generateWinningStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        return WinningStatistics.computeWinningStatistics(lottoTickets, lottoResult);
    }

    public double computeEarningRate(WinningStatistics winningStatistics) {
        return winningStatistics.computeEarningRate();
    }
}
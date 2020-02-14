package lottogame.domain.winninglotto;

import lottogame.domain.MoneyAmount;
import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class WinningLottos {

    private final List<WinningLotto> winningStatistics;

    public WinningLottos(List<WinningLotto> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public static WinningLottos computeWinningStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        List<WinningLotto> winningStatistics = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            WinningLotto winningLotto = WinningLotto.computeLottoStatistics(lottoTicket, lottoResult);
            winningStatistics.add(winningLotto);
        }
        return new WinningLottos(winningStatistics);
    }

    public List<WinningLotto> getWinningStatistics() {
        return winningStatistics;
    }

    public int countLottoStatistics(WinningLotto winningLotto) {
        int count = 0;
        for (WinningLotto rank : winningStatistics) {
            if (rank == winningLotto) count += 1;
        }
        return count;
    }

    public double computeEarningRate() {
        return (totalPrizeMoney() / (winningStatistics.size() * MoneyAmount.ONE_LOTTO_PRICE))
                * 100;
    }

    private double totalPrizeMoney() {
        double totalPrizeMoney = 0;
        for(WinningLotto winningLotto : winningStatistics) {
            totalPrizeMoney += winningLotto.getPrizeMoney();
        }
        return totalPrizeMoney;
    }
}

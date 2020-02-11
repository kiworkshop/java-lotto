package lottogame.domain.statistics;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {

    private final List<LottoStatistics> winningStatistics;

    public WinningStatistics(List<LottoStatistics> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    public static WinningStatistics computeWinningStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        List<LottoStatistics> winningStatistics = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            LottoStatistics lottoStatistics = LottoStatistics.computeLottoStatistics(lottoTicket, lottoResult);
            winningStatistics.add(lottoStatistics);
        }
        return new WinningStatistics(winningStatistics);
    }

    public List<LottoStatistics> getWinningStatistics() {
        return winningStatistics;
    }

    public int countLottoStatistics(LottoStatistics lottoStatistics) {
        int count = 0;
        for (LottoStatistics rank : winningStatistics) {
            if (rank == lottoStatistics) count += 1;
        }
        return count;
    }
}

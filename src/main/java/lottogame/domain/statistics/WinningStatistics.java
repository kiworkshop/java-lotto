package lottogame.domain.statistics;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

import java.util.List;

public class WinningStatistics {

    private List<LottoStatistics> winningStatistics;

    public WinningStatistics computeLottoStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        computeFisrstPrizeLottoStatistics();
    }
}

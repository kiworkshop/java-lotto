package lottogame.domain.winninglotto;

import lottogame.domain.LottoCount;
import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class WinningLottos {

    private final List<WinningLotto> winningLottos;

    public WinningLottos(List<WinningLotto> winningStatistics) {
        this.winningLottos = winningStatistics;
    }

    public static WinningLottos computeWinningStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        List<WinningLotto> winningLottos = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            WinningLotto winningLotto = WinningLotto.computeLottoStatistics(lottoTicket, lottoResult);
            winningLottos.add(winningLotto);
        }
        return new WinningLottos(winningLottos);
    }

    public int countWinningLotto(WinningLotto winningLotto) {
        int count = 0;
        for (WinningLotto rank : winningLottos) {
            if (rank == winningLotto) count += 1;
        }
        return count;
    }

    public double computeEarningRate() {
        return (totalPrizeMoney() / (winningLottos.size() * LottoCount.ONE_LOTTO_PRICE))
                * 100;
    }

    private double totalPrizeMoney() {
        double totalPrizeMoney = 0;
        for(WinningLotto winningLotto : winningLottos) {
            totalPrizeMoney += winningLotto.getPrizeMoney();
        }
        return totalPrizeMoney;
    }

    public List<WinningLotto> getWinningLottos() {
        return winningLottos;
    }
}

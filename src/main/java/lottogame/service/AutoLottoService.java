package lottogame.service;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.winninglotto.WinningLottos;

public class AutoLottoService {

    public LottoTickets generateLottoTickets(int lottoCount) {
        return LottoTickets.with(lottoCount);
    }

    public LottoTicket generateLottoTicket(String lottoNumbersString) {
        return LottoTicket.of(lottoNumbersString);
    }

    public WinningLottos generateWinningStatistics(LottoTickets lottoTickets, LottoTicket lottoResult) {
        return WinningLottos.computeWinningStatistics(lottoTickets, lottoResult);
    }

    public double computeEarningRate(WinningLottos winningLottos) {
        return winningLottos.computeEarningRate();
    }
}
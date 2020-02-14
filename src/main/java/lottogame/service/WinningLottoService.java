package lottogame.service;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.winninglotto.WinningLottos;

public class WinningLottoService {

    public WinningLottos generateWinningLottos(LottoTickets lottoTickets, LottoTicket lottoResult, int bonusNumber) {
        return WinningLottos.createWith(lottoTickets, lottoResult, bonusNumber);
    }

    public double computeEarningRate(WinningLottos winningLottos) {
        return winningLottos.computeEarningRate();
    }
}

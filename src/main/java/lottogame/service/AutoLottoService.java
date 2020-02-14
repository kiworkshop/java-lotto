package lottogame.service;

import lottogame.domain.lottoticket.LottoTickets;

public class AutoLottoService {

    public LottoTickets generateLottoTickets(int lottoCount) {
        return LottoTickets.createBy(lottoCount);
    }
}
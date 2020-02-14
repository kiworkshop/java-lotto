package lottogame.service;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

public class ManualLottoService {

    public LottoTickets generateLottoTickets(String[] lottoNumbersList) {
        return LottoTickets.createWith(lottoNumbersList);
    }

    public LottoTicket generateLottoTicket(String lottoNumbersString) {
        return LottoTicket.createWith(lottoNumbersString);
    }
}

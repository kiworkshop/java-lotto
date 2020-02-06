package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets with(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        return new LottoTickets(lottoTickets);
    }
}

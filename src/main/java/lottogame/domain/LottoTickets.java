package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets with(int lottoCount) {
        List<LottoTicket> lottoTickets = generateLottoTickets(lottoCount);
        return new LottoTickets(lottoTickets);
    }

    private static List<LottoTicket> generateLottoTickets(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            LottoTicket lottoTicket = generateLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        return LottoTicket.generateLottoTicket();
    }
}

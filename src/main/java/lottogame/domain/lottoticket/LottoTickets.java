package lottogame.domain.lottoticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createWith(String[] lottoNumbersList) {

    }

    public static LottoTickets createBy(int lottoCount) {
        List<LottoTicket> lottoTickets = generateLottoTickets(lottoCount);
        return new LottoTickets(lottoTickets);
    }

    private static List<LottoTicket> generateLottoTickets(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoTicket lottoTicket = generateLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        return lottoTicket.create();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}

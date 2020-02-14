package lottogame.domain.lottoticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createWith(String[] lottoNumbersList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(String lottoNumbers : lottoNumbersList) {
            LottoTicket lottoTicket = LottoTicket.createWith(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets createBy(int lottoCount) {
        List<LottoTicket> lottoTickets = generateRandomLottoTickets(lottoCount);
        return new LottoTickets(lottoTickets);
    }

    private static List<LottoTicket> generateRandomLottoTickets(int lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoTicket lottoTicket = generateRandomLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private static LottoTicket generateRandomLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        return lottoTicket.create();
    }

    public static LottoTickets joinLottoTickets(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(manualLottoTickets.getLottoTickets());
        lottoTickets.addAll(autoLottoTickets.getLottoTickets());
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}

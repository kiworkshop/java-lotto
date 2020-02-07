package lottogame.domain.lottoticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        for (int i = 0; i < lottoCount; i++) {
            LottoTicket lottoTicket = generateLottoTicket();
            lottoTickets.add(lottoTicket);
        }

        checkForDuplicates(lottoTickets);
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        return lottoTicket.generateLottoTicket();
    }

    private static void checkForDuplicates(List<LottoTicket> lottoTickets) {
        Set<LottoTicket> lottoTicketSet = new HashSet<>(lottoTickets);
        if (lottoTickets.size() != lottoTicketSet.size()) throw new IllegalArgumentException();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}

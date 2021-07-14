package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public void add(List<LottoTicket> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> values() {
        return lottoTickets;
    }
}

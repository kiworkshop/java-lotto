package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    public static final int LOTTO_PRICE = 1000;

    public static List<LottoTicket> buyLottoTickets(long money) {
        List<LottoTicket> tickets = new ArrayList<>();
        long numTickets = money / LOTTO_PRICE;
        for (long i = 0; i < numTickets; i++) {
            tickets.add(new LottoTicket().ofRandom());
        }
        return tickets;
    }
}

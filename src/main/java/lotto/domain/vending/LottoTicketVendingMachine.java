package lotto.domain.vending;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketVendingMachine {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();

    public List<LottoTicket> issueTickets(BuyingPrice buyingPrice) {
        return IntStream.range(0, buyingPrice.ticketAmount())
                .mapToObj(i -> LOTTO_GENERATOR.issueAutoLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}

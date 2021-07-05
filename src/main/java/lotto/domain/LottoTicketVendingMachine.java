package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketVendingMachine {
    public static final int TICKET_PRICE = 1000;
    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    public List<LottoTicket> issueTickets(BuyingPrice buyingPrice) {
        int ticketAmount = divide(buyingPrice);
        return IntStream.range(0, ticketAmount)
                .mapToObj(i -> lottoGenerator.issueAutoLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    private int divide(BuyingPrice buyingPrice) {
        return (buyingPrice.value() / TICKET_PRICE);
    }
}

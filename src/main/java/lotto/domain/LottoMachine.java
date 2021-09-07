package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final int LOTTO_TICKET_PRICE = 1_000;
    private final int ticketCount;
    private final int manualTicketCount;

    public LottoMachine(PurchaseMoney purchaseMoney, int manualTicketCount) {
        this.ticketCount = purchaseMoney.getMoneyValue() / LOTTO_TICKET_PRICE;
        this.manualTicketCount = manualTicketCount;
    }

    public List<LottoTicket> buyManualTickets(List<List<Integer>> manualTicketNumbers) {
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < manualTicketCount; i++) {
            LottoTicket lottoTicket = new LottoTicket(manualTicketNumbers.get(i));
            purchasedLottoTickets.add(lottoTicket);
        }
        return purchasedLottoTickets;
    }

    public int getAutoTicketCount() {
        if (this.ticketCount < manualTicketCount) {
            throw new IllegalArgumentException("구매 가능한 티켓의 수를 초과하여 입력하셨습니다.");
        }
        return this.ticketCount - manualTicketCount;
    }

    public List<LottoTicket> buyAutoTickets() {
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < getAutoTicketCount(); i++) {
            LottoTicket lottoTicket = new LottoTicket(createNonDuplicateNumbers());
            purchasedLottoTickets.add(lottoTicket);
        }
        return purchasedLottoTickets;
    }

    private List<Integer> createNonDuplicateNumbers() {
        List<Integer> balls = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(balls);
        List<Integer> numbers = balls.subList(0, 6);
        Collections.sort(numbers);
        return numbers;
    }

}

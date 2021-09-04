package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;

    public LottoMachine(PurchaseMoney purchaseMoney) {
        this.lottoTicketCount = purchaseMoney.getMoneyValue() / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return this.lottoTicketCount;
    }

    public List<LottoTicket> buyLottoTickets() {
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
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

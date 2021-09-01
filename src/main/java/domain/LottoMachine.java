package domain;

import enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;

    public LottoMachine(int givenMoney) {
        this.lottoTicketCount = givenMoney / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return this.lottoTicketCount;
    }

    public List<Integer> createNonDuplicateNumbers() {
        List<Integer> balls = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(balls);
        List<Integer> numbers = balls.subList(0, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public List<LottoTicket> buyLottoTickets() {
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            LottoTicket lottoTicket = new LottoTicket(createNonDuplicateNumbers());
            purchasedLottoTickets.add(lottoTicket);
        }
        return purchasedLottoTickets;
    }

//    public List<LottoTicket> getRankResult(List<LottoTicket> matchingLottos, List<Integer> winningNumber, int bonusNumber) {
//        for (LottoTicket matchingLotto : matchingLottos) {
//            matchingLotto.getRank(winningNumber, bonusNumber);
//        }
//        return matchingLottos;
//    }
//
//    public Map getRankResult(List<WinningLotto> lottos) {
//
//        Map<Rank, Integer> result = new TreeMap<Rank, Integer>() {{
//            put(Rank.FIRST_PLACE, 0);
//            put(Rank.SECOND_PLACE, 0);
//            put(Rank.THIRD_PLACE, 0);
//            put(Rank.FOURTH_PLACE, 0);
//            put(Rank.FIFTH_PLACE, 0);
//            put(Rank.MISS, 0);
//        }};
//
//        for (WinningLotto lotto : lottos) {
//            result.put(lotto.getRank(), result.get(lotto.getRank()) + 1);
//        }
//
//        return result;
//    }

    public double getProfitRate(int givenMoney, Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble((rank) -> rank.getKey().prize() * rank.getValue())
                .sum();
        return totalPrize / givenMoney;
    }
}

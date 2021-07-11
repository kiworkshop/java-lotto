package domain;

import enums.Rank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private int lottoTicketCount;

    public LottoMachine(int givenMoney) {
        this.lottoTicketCount = givenMoney / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return this.lottoTicketCount;
    }

    public List<Integer> createRandomNumber() {
        List<Integer> balls = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(balls);
        List<Integer> lottoNumbers = balls.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> getLottoTickets() {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTicket.add(new Lotto(createRandomNumber()));
        }
        return lottoTicket;
    }

    public List<Lotto> getRankResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.setRank(winningNumber, bonusNumber);
        }
        return lottos;
    }

    public Map getRankResult(List<Lotto> lottos) {

        Map<Rank, Integer> result = new TreeMap<Rank, Integer>() {{
            put(Rank.FIRST_PLACE, 0);
            put(Rank.SECOND_PLACE, 0);
            put(Rank.THIRD_PLACE, 0);
            put(Rank.FOURTH_PLACE, 0);
            put(Rank.FIFTH_PLACE, 0);
            put(Rank.ETC, 0);
        }};

        for (Lotto lotto : lottos) {
            result.put(lotto.getRank(), result.get(lotto.getRank()) + 1);
        }

        return result;
    }

    public double getProfitRate(int givenMoney, Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble((rank) -> rank.getKey().prize() * rank.getValue())
                .sum();
        return totalPrize / givenMoney;
    }
}

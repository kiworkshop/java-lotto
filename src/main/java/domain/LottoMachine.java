package domain;

import enums.Rank;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;
    private static final String LOTTO_PRICE_PATTERN = "\\d*000";
    private final int money;
    public LottoMachine(String inputMoney) {
        this.money = checkGivenMoney(inputMoney);
        this.lottoTicketCount = this.money / LOTTO_PRICE;
    }

    private int checkGivenMoney(String givenMoney) {
        if (!Pattern.matches(LOTTO_PRICE_PATTERN, givenMoney)) {
            throw new RuntimeException("1000원 단위의 금액만 투입할 수 있습니다.");
        }
        return Integer.parseInt(givenMoney);
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

    public TreeMap getRankResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {

        TreeMap<Rank, Integer> result = new TreeMap<Rank, Integer>() {{
            put(Rank.FIRST_PLACE, 0);
            put(Rank.SECOND_PLACE, 0);
            put(Rank.THIRD_PLACE, 0);
            put(Rank.FOURTH_PLACE, 0);
            put(Rank.FIFTH_PLACE, 0);
            put(Rank.ETC, 0);
        }};

        for (Lotto lotto : lottos) {
            result.put(lotto.getRank(winningNumber, bonusNumber), result.get(lotto.getRank(winningNumber, bonusNumber)) + 1);
        }

        return result;
    }

    public double getProfitRate(Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble((rank) -> rank.getKey().prize() * rank.getValue())
                .sum();
        return totalPrize / this.money;
    }
}

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private static final int WINNING_COUNT_FROM = 3;
    private static final int WINNING_COUNT_TO = 6;
    private HashMap<Integer, Integer> matchCount;
    private int[] PRIZE_FOR_ORDER = {0, 0, 5000, 50000, 1500000, 2000000000};

    private LottoResult(HashMap<Integer, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    static LottoResult of(List<Integer> matchCounts) {
        HashMap<Integer, Integer> matchCount = new HashMap<>();
        for (int i = WINNING_COUNT_FROM; i <= WINNING_COUNT_TO; i++) {
            int finalI = i;
            matchCount.put(i, (int) matchCounts.stream().filter(Count -> Count.equals(finalI)).count());
        }
        return new LottoResult(matchCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = WINNING_COUNT_FROM; i <= WINNING_COUNT_TO; i++) {
            sb.append(i + "개 일치 (" + PRIZE_FOR_ORDER[i - 1] + ") - " + matchCount.get(i) + "개\n");
        }
        return sb.toString();
    }

    public int getMatch(int matchedCountInLottto) {
        return matchCount.get(matchedCountInLottto);
    }

    public int getPrize() {
        int prize = 0;
        for (int i = WINNING_COUNT_FROM; i <= WINNING_COUNT_TO; i++) {
            prize += getMatch(i) * PRIZE_FOR_ORDER[i - 1];
        }
        return prize;
    }
}

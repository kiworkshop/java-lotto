import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private HashMap<Integer, Integer> matchCount;
    private int[] PRIZE_FOR_ORDER = {0, 0, 5000, 50000, 1500000, 2000000000};

    public LottoResult(HashMap<Integer, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoResult of(List<Integer> matchCounts) {
        HashMap<Integer, Integer> matchCount = new HashMap<>();
        for (int i = 3; i <= 6; i++) {
            int finalI = i;
            matchCount.put(i, (int) matchCounts.stream().filter(Count -> Count.equals(finalI)).count());
        }
        return new LottoResult(matchCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= 6; i++) {
            sb.append(i + "개 일치 (" + PRIZE_FOR_ORDER[i - 1] + ") - " + matchCount.get(i) + "개\n");
        }
        return sb.toString();
    }

    public int get3Match() {
        return matchCount.get(3);
    }

    public int get4Match() {
        return matchCount.get(4);
    }

    public int get5Match() {
        return matchCount.get(5);
    }

    public int get6Match() {
        return matchCount.get(6);
    }

    public int getMatch(int matchedCountInLottto) {
        return matchCount.get(matchedCountInLottto);
    }

    public int getPrize() {
        int prize = 0;
        for (int i = 3; i <= 6; i++) {
            prize += getMatch(i) * PRIZE_FOR_ORDER[i - 1];
        }
        return prize;
    }
}

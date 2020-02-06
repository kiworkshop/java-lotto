import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private HashMap<Integer, Integer> matchCount;

    public LottoResult(HashMap<Integer, Integer> matchCount) {
        this.matchCount = matchCount;
    }

    public static LottoResult of(List<Integer> matchCounts) {
        HashMap<Integer, Integer> matchCount = new HashMap<>();
        for (int i = 0; i <= 6; i++) {
            int finalI = i;
            matchCount.put(i, (int) matchCounts.stream().filter(Count -> Count.equals(finalI)).count());
        }
        return new LottoResult(matchCount);
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
}

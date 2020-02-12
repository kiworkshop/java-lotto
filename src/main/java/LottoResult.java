import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private HashMap<LottoRank, Integer> lottoRankToCountOfMatches;

    private LottoResult(HashMap<LottoRank, Integer> lottoRankToCountOfMatches) {
        this.lottoRankToCountOfMatches = lottoRankToCountOfMatches;
    }

    static LottoResult of(List<Integer> countOfMatchesForEachLotto) {
        HashMap<LottoRank, Integer> matchCount = new HashMap<>();
        for (int i = LottoRank.WINNING_COUNT_MIN; i <= LottoRank.WINNING_COUNT_MAX; i++) {
            int finalI = i;
            matchCount.put(LottoRank.valueOf(i), (int) countOfMatchesForEachLotto.stream().filter(Count -> Count.equals(finalI)).count());
        }
        return new LottoResult(matchCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : lottoRankToCountOfMatches.keySet()) {
            sb.append(lottoRank.getCountOfMatches()).append("개 일치 (").append(lottoRank.getPrize()).append(") - ").append(lottoRankToCountOfMatches.get(lottoRank)).append("개\n");
        }
        return sb.toString();
    }

    public int getMatch(int matchedCountInLottto) {
        return lottoRankToCountOfMatches.get(matchedCountInLottto);
    }

    public int getPrize() {
        int prize = 0;
        for (LottoRank lottoRank : lottoRankToCountOfMatches.keySet()) {
            prize += lottoRankToCountOfMatches.get(lottoRank) * lottoRank.getPrize();
        }
        return prize;
    }
}

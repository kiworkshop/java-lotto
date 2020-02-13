import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private HashMap<LottoRank, Integer> lottoRankToCountOfMatches;

    private LottoResults(HashMap<LottoRank, Integer> lottoRankToCountOfMatches) {
        this.lottoRankToCountOfMatches = lottoRankToCountOfMatches;
    }

    static LottoResults of(List<LottoRank> countOfMatchesForEachLotto) {
        HashMap<LottoRank, Integer> matchCount = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            matchCount.put(lottoRank, (int) countOfMatchesForEachLotto.stream().filter(Count -> Count.equals(lottoRank)).count());
        }
        return new LottoResults(matchCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : lottoRankToCountOfMatches.keySet()) {
            sb.append(lottoRank.getCountOfMatches()).append("개 일치 (").append(lottoRank.getPrize()).append(") - ").append(lottoRankToCountOfMatches.get(lottoRank)).append("개\n");
        }
        return sb.toString();
    }

    public int getMatch(LottoRank lottoRank) {
        return lottoRankToCountOfMatches.get(lottoRank);
    }

    public int getPrize() {
        int prize = 0;
        for (LottoRank lottoRank : lottoRankToCountOfMatches.keySet()) {
            prize += lottoRankToCountOfMatches.get(lottoRank) * lottoRank.getPrize();
        }
        return prize;
    }
}

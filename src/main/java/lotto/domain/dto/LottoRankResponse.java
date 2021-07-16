package lotto.domain.dto;

import lotto.domain.LottoRank;

import java.util.AbstractMap;
import java.util.Map;

public class LottoRankResponse {
    private final Map.Entry<LottoRank, Integer> rank;

    public LottoRankResponse(final Map.Entry<LottoRank, Integer> rank) {
        this.rank = new AbstractMap.SimpleEntry<>(rank);
    }

    public int getMatchedLottoNumbersCount() {
        return rank.getKey().getMatchedCount();
    }

    public long getTotalPrize() {
        return rank.getKey().multiplyPrizeBy(rank.getValue());
    }

    public int getMatchedRankCount() {
        return rank.getValue();
    }

    public boolean hasBouns() {
        return rank.getKey().equals(LottoRank.SECOND);
    }
}

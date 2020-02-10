package lottogame.domain.statistics;

public enum LottoStatistics {
    FIRST(6, 2000000);

    private int hitCount;
    private long prizePrice;

    LottoStatistics(int hitCount, long prizePrice) {
        this.hitCount = hitCount;
        this.prizePrice = prizePrice;
    }
}

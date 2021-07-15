package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000), // 보너스볼 일치
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    LOSE(0, 0, 0);

    private final int hitCount;
    private final int hitBonus;
    private final int prizeMoney;

    LottoRank(int hitCount, int hitBonus, int prizeMoney) {
        this.hitCount = hitCount;
        this.hitBonus = hitBonus;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findBy(int hitCount, int hitBonus) {
        return Arrays.stream(values())
                .filter(rank -> (rank.hitCount == hitCount) && (rank.hitBonus == hitBonus))
                .findFirst()
                .orElse(LottoRank.LOSE);
    }

    public int hitCount() {
        return hitCount;
    }

    public int hitBonus() {
        return hitBonus;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}


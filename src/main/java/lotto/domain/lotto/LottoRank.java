package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    LOSE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000), // 보너스볼 일치
    FIRST(6, 2_000_000_000);

    private final int hitCount;
    private final int prizeMoney;

    LottoRank(int hitCount, int prizeMoney) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findBy(int hitCount, boolean isBonus) {
        if (hitCount == 5) {
            return isBonus ? LottoRank.SECOND : LottoRank.THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.hitCount == hitCount)
                .findFirst()
                .orElse(LottoRank.LOSE);
    }

    public int hitCount() {
        return hitCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}


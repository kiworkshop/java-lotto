package lotto.constant;

import lombok.Getter;
import lotto.domain.PrizeCount;

@Getter
public enum Prize {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSE(2, false, 0);

    private final int matchNumbersCount;
    private final boolean isBonus;
    private final long prizeMoney;

    Prize(int matchNumbersCount, boolean isBonus, long prizeMoney) {
        this.matchNumbersCount = matchNumbersCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize findPrize(int matchNumbersCount, boolean isBonus) {
        if (matchNumbersCount <= LOSE.matchNumbersCount) {
            return LOSE;
        }
        if (matchNumbersCount == FIFTH.matchNumbersCount) {
            return FIFTH;
        }
        if (matchNumbersCount == FOURTH.matchNumbersCount) {
            return FOURTH;
        }
        if (matchNumbersCount == FIRST.matchNumbersCount) {
            return FIRST;
        }
        return dissolveSecondOrThird(isBonus);
    }

    private static Prize dissolveSecondOrThird(boolean isBonus) {
        if (isBonus) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    public static long sumOfPrizeMoney(PrizeCount prizeCount) {
        return prizeCount.getCountFirst() * FIRST.prizeMoney
                + prizeCount.getCountSecond() * SECOND.prizeMoney
                + prizeCount.getCountThird() * THIRD.prizeMoney
                + prizeCount.getCountFourth() * FOURTH.prizeMoney
                + prizeCount.getCountFifth() * FIFTH.prizeMoney;
    }
}

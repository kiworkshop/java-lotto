package lotto.constant;

public enum PrizeCondition {

    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    LOSE(2, false);

    private final int matchNumbersCount;
    private final boolean isBonus;

    PrizeCondition(int matchNumbersCount, boolean isBonus) {
        this.matchNumbersCount = matchNumbersCount;
        this.isBonus = isBonus;
    }

    public static PrizeCondition findPrize(int matchNumbersCount, boolean isBonus) {
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

    private static PrizeCondition dissolveSecondOrThird(boolean isBonus) {
        if (isBonus) {
            return PrizeCondition.SECOND;
        }
        return PrizeCondition.THIRD;
    }
}

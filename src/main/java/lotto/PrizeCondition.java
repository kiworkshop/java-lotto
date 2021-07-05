package lotto;

public enum PrizeCondition {

    FIRST(6, false),
    SECOND(6, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false);

    private final int matchNumbersCount;
    private final boolean isBonus;

    PrizeCondition(int matchNumbersCount, boolean isBonus) {
        this.matchNumbersCount = matchNumbersCount;
        this.isBonus = isBonus;
    }


    public static PrizeCondition findPrize(int matchNumbersCount, boolean isBonus) {
        if (matchNumbersCount == FIFTH.matchNumbersCount) {
            return FIFTH;
        }
        if (matchNumbersCount == FOURTH.matchNumbersCount) {
            return FOURTH;
        }
        if (matchNumbersCount == THIRD.matchNumbersCount) {
            return THIRD;
        }
        return dissolveFirstOrSecond(isBonus);
    }

    private static PrizeCondition dissolveFirstOrSecond(boolean isBonus) {
        if (isBonus) {
            return PrizeCondition.SECOND;
        }
        return PrizeCondition.FIRST;
    }
}

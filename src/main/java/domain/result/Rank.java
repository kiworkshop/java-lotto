package domain.result;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatches;
    private long winningMoney;

    private Rank(int countOfMatches, long winningMoney) {
        this.countOfMatches = countOfMatches;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatches) {
        if (countOfMatches == FIRST.countOfMatches) {
            return FIRST;
        }
        if (countOfMatches == SECOND.countOfMatches) {
            return SECOND;
        }
        if (countOfMatches == THIRD.countOfMatches) {
            return THIRD;
        }
        if (countOfMatches == FOURTH.countOfMatches) {
            return FOURTH;
        }
        return MISS;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}

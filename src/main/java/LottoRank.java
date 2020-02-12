import java.util.Arrays;

public enum LottoRank {
    SIX(6, 2000000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000);

    public static int WINNING_COUNT_MIN = 3;
    public static int WINNING_COUNT_MAX = 6;

    private int countOfMatches;

    public int getPrize() {
        return prize;
    }

    public int getCountOfMatches() {
        return countOfMatches;
    }

    private int prize;

    LottoRank(int countOfMatches, int prize) {
        this.countOfMatches = countOfMatches;
        this.prize = prize;
    }

    public static LottoRank valueOf(int countOfMatches) {
        return Arrays.stream(values())
                .filter(rank -> rank
                        .countOfMatches == countOfMatches)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }

}
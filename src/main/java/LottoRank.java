import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

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
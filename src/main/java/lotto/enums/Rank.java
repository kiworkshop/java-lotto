package lotto.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIFTH_PLACE(3, 0, 5_000),
    FOURTH_PLACE(4, 0, 50_000),
    THIRD_PLACE(5, 0, 1_500_000),
    SECOND_PLACE(5, 1, 30_000_000),
    FIRST_PLACE(6, 0, 2_000_000_000);

    private final int matched;
    private final int bonusMatched;
    private final int prize;

    Rank(int matched, int bonusMatched, int prize) {
        this.matched = matched;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
    }

    public static Optional<Rank> getRank(int matchCount, int bonusCount) {
        return Arrays.stream(values())
                .filter(rank -> (rank.matched == matchCount) && (rank.bonusMatched == bonusCount))
                .findAny();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatched() {
        return matched;
    }

    public boolean isSecondPlace(Rank rank) {
        return rank == Rank.SECOND_PLACE;
    }
}

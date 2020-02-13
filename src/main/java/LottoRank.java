import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0,0);

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
        if (countOfMatches < WINNING_COUNT_MIN) {
            return MISS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank
                        .countOfMatches == countOfMatches && !rank.equals(SECOND))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }

    public static LottoRank checkHits(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> addedNumbers = new ArrayList<>();    //TODO  contains를 쓰며 indent를 지키는 방법이 궁금
        addedNumbers.addAll(lotto.getNumbers());
        addedNumbers.addAll(winningNumbers.getNumbers());
        int countOfMatches = addedNumbers.size() - new HashSet<Integer>(addedNumbers).size();
        if (countOfMatches == 5 && lotto.getNumbers().contains(winningNumbers.getBonusNumber())) {
            return LottoRank.SECOND;
        }
        return LottoRank.valueOf(countOfMatches);
    }

}
package domain;

import enums.Rank;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> randomNumber) {
        this.lottoNumbers = randomNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Rank getRank(List<Integer> winningNumber, int bonusNumber) {
        countOfMatches(winningNumber);
        countOfBonusMatch(bonusNumber);
        return Rank.getRank(countOfMatches(winningNumber), countOfBonusMatch(bonusNumber));
    }

    private int countOfMatches(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private int countOfBonusMatch(int bonusNumber) {
        return (lottoNumbers.contains(bonusNumber) ? 1 : 0);
    }
}

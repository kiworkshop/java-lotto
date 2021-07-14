package domain;

import enums.Rank;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;
    private Rank rank;

    public Lotto(List<Integer> randomNumber) {
        this.lottoNumbers = randomNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public String getLottoNumberString() {
        String lottoString = "[";
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            lottoString = lottoString + lottoNumbers.get(i) + ", ";
        }
        lottoString = lottoString + lottoNumbers.get(lottoNumbers.size() - 1) + "]";
        return lottoString;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(List<Integer> winningNumber, int bonusNumber) {
        countOfMatches(winningNumber);
        countOfBonusMatch(bonusNumber);
        rank = Rank.getRank(countOfMatches(winningNumber), countOfBonusMatch(bonusNumber));
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

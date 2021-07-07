package domain;

import enums.Rank;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private int matchCount;
    private int bonusCount;

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

    public Rank getRank(List<Integer> winningNumber, int bonusNumber) {
        countOfMatches(winningNumber);  // 숫자로 몇개 맞는지 count
        countOfBonusMatch(bonusNumber); // boolean 보너스가 맞는지 줌
        return Rank.getRank(matchCount, bonusCount);
    }

    private void countOfMatches(List<Integer> winningNumbers) {
        matchCount = (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private void countOfBonusMatch(int bonusNumber) {
        bonusCount = (lottoNumbers.contains(bonusNumber) ? 1 : 0);
    }
}

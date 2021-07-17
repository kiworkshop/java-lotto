package lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lotto.constant.Prize;
import lotto.parser.LottoParser;

import java.util.Comparator;

public class WinningLotto extends Lotto {

    @Getter
    private final LottoNumber bonusNumber;

    @Builder
    public WinningLotto(String winningNumberInput, String bonusNumberInput) throws IllegalArgumentException {
        super(LottoParser.parseInputIntoLottoNumbers(winningNumberInput));
        this.bonusNumber = new LottoNumber(bonusNumberInput);
        this.lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
    }

    public Prize findPrizeCondition(Lotto targetLotto) {
        return Prize.findPrize(getMatchNumbersCount(targetLotto), isBonusMatch(targetLotto));
    }

    private int getMatchNumbersCount(Lotto targetLotto) {
        targetLotto.getLottoNumbers().sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
        int targetIdx = 0, winningIdx = 0;
        int matchNumbersCount = 0;
        while (targetIdx < targetLotto.lottoNumbers.size() && winningIdx < this.lottoNumbers.size()) {
            int targetNumber = targetLotto.lottoNumbers.get(targetIdx).getLottoNumber();
            int winningNumber = this.lottoNumbers.get(winningIdx).getLottoNumber();
            if (targetNumber == winningNumber) {
                matchNumbersCount++;
                targetIdx++;
                winningIdx++;
            } else if (targetNumber > winningNumber) {
                winningIdx++;
            } else {
                targetIdx++;
            }
        }
        return matchNumbersCount;
    }

    private boolean isBonusMatch(Lotto targetLotto) {
        return targetLotto.getLottoNumbers().contains(bonusNumber);
    }

}

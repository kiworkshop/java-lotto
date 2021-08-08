package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.parser.LottoParser;
import lotto.util.NumberValidateUtils;

import java.util.Comparator;

@Getter
public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String winningNumberInput, String bonusNumberInput) {
        this.lotto = new Lotto(LottoParser.generateLotto(winningNumberInput));
        this.bonusNumber = new LottoNumber(NumberValidateUtils.parseLottoNumber(bonusNumberInput));
    }

    public WinningLotto(WinningLottoInputDTO winningLottoInputDTO) {
        this(winningLottoInputDTO.getWinningLottoNumbers(), winningLottoInputDTO.getWinningLottoBonus());
    }

    public Prize findPrize(Lotto targetLotto) {
        return Prize.findPrize(getMatchNumbersCount(targetLotto), isBonusMatch(targetLotto));
    }

    private boolean isBonusMatch(Lotto targetLotto) {
        return targetLotto.getLottoNumbers().contains(bonusNumber);
    }

    private int getMatchNumbersCount(Lotto targetLotto) {
        targetLotto.getLottoNumbers().sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
        this.lotto.getLottoNumbers().sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
        int targetIdx = 0;
        int winningIdx = 0;
        int matchNumbersCount = 0;
        while (targetIdx < targetLotto.lottoNumbers.size() && winningIdx < this.lotto.getLottoNumbers().size()) {
            int targetNumber = targetLotto.lottoNumbers.get(targetIdx).getLottoNumber();
            int winningNumber = this.lotto.getLottoNumbers().get(winningIdx).getLottoNumber();
            if (targetNumber == winningNumber) {
                matchNumbersCount++;
                targetIdx++;
                winningIdx++;
            }
            else if (targetNumber > winningNumber) {
                winningIdx++;
            }
            else {
                targetIdx++;
            }
        }
        return matchNumbersCount;
    }

}

package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.parser.LottoParser;
import lotto.util.NumberValidateUtils;

import java.util.HashSet;

@Getter
public class WinningLotto {

    public static final int ALL_LOTTO_NUMBERS_OF_TWO_LOTTO_TICKET = 12;
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
        HashSet<LottoNumber> distinctLottoNumbersSet = new HashSet<>();
        distinctLottoNumbersSet.addAll(lotto.getLottoNumbers());
        distinctLottoNumbersSet.addAll(targetLotto.getLottoNumbers());

        return ALL_LOTTO_NUMBERS_OF_TWO_LOTTO_TICKET - distinctLottoNumbersSet.size();
    }

}

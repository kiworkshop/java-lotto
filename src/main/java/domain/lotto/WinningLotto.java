package domain.lotto;

import java.util.Set;

public class WinningLotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;

    public static WinningLotto from(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }
}

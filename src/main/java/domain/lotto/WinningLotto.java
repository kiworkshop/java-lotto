package domain.lotto;

import domain.result.Rank;

public class WinningLotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Rank getRank(Lotto userLotto) {
        return Rank.valueOf(countMatches(userLotto));
    }

    private int countMatches(Lotto userLotto) {
        return winningLotto.match(userLotto);
    }
}

package domain.lotto;

public class WinningLotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public static WinningLotto from(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(Lotto userLotto) {
        return winningLotto.match(userLotto);
    }
}

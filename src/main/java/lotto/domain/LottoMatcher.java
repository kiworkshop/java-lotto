package lotto.domain;

public class LottoMatcher {

    private final WinningLotto winningLotto;
    private final LottoSet lottoSet;

    public LottoMatcher(WinningLotto winningLotto, LottoSet lottoSet) {
        this.winningLotto = winningLotto;
        this.lottoSet = lottoSet;
    }

    public PrizeCount countPrizes() {
        PrizeCount prizeCount = new PrizeCount();
        for (Lotto lotto : lottoSet.getLottoSet()) {
            Prize prize = Prize.getMatchPrize(getMatchNumbersCount(lotto), isBonusMatch(lotto));
            prizeCount.addPrize(prize);
        }
        return prizeCount;
    }

    private int getMatchNumbersCount(Lotto targetLotto) {
        return (int) targetLotto.getLottoNumbers().stream()
                .filter(lottoNumber -> winningLotto.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    private boolean isBonusMatch(Lotto targetLotto) {
        return targetLotto.getLottoNumbers().contains(winningLotto.getBonusNumber());
    }
}
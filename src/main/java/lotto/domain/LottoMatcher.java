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
            Prize prize = Prize.getPrize(getMatchNumbersCount(lotto), isBonusMatch(lotto));
            prizeCount.addPrize(prize);
        }
        return prizeCount;
    }

    private int getMatchNumbersCount(Lotto targetLotto) {
        int targetIdx = 0, winningIdx = 0;
        int matchNumbersCount = 0;
        while (targetIdx < targetLotto.getLottoNumbers().size() && winningIdx < winningLotto.getLottoNumbers().size()) {
            int targetNumber = targetLotto.getLottoNumbers().get(targetIdx).getLottoNumber();
            int winningNumber = winningLotto.getLottoNumbers().get(winningIdx).getLottoNumber();
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
        return targetLotto.getLottoNumbers().contains(winningLotto.getBonusNumber());
    }
}
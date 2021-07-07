package lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lotto.constant.PrizeCondition;

@Getter
public class PrizeCount {

    private int countFirst;
    private int countSecond;
    private int countThird;
    private int countFourth;
    private int countFifth;

    @Builder
    public PrizeCount(LottoSet lottoset, WinningLotto winningLotto) {
        for (Lotto lotto : lottoset.getLottoSet()) {
            updateCounts(winningLotto.findPrizeCondition(lotto));
        }
    }

    private void updateCounts(PrizeCondition prizeCondition) {
        if (prizeCondition.equals(PrizeCondition.FIRST)) {
            countFirst++;
            return;
        }
        if (prizeCondition.equals(PrizeCondition.SECOND)) {
            countSecond++;
            return;
        }
        if (prizeCondition.equals(PrizeCondition.THIRD)) {
            countThird++;
            return;
        }
        if (prizeCondition.equals(PrizeCondition.FOURTH)) {
            countFourth++;
            return;
        }
        if (prizeCondition.equals(PrizeCondition.FIFTH)) {
            countFifth++;
        }
    }
}

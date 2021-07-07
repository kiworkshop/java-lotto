package lotto.domain;

import lombok.Getter;
import lotto.constant.PrizeCondition;

@Getter
public class PrizeCount {
    private int countFirst;
    private int countSecond;
    private int countThird;
    private int countFourth;
    private int countFifth;

    public PrizeCount(LottoSet lottoset, WinningLotto winningLotto) {
        for (Lotto lotto : lottoset.getLottoSet()) {
            updateCounts(winningLotto.findPrize(lotto));
        }
    }

    private void updateCounts(PrizeCondition condition) {
        if(condition.equals(PrizeCondition.FIRST)) {
            countFirst++;
            return;
        }
        if(condition.equals(PrizeCondition.SECOND)) {
            countSecond++;
            return;
        }
        if(condition.equals(PrizeCondition.THIRD)) {
            countThird++;
            return;
        }
        if(condition.equals(PrizeCondition.FOURTH)) {
            countFourth++;
            return;
        }
        if(condition.equals(PrizeCondition.FIFTH)) {
            countFifth++;
        }
    }
}

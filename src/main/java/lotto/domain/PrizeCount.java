package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;

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

    private void updateCounts(Prize condition) {
        if(condition.equals(Prize.FIRST)) {
            countFirst++;
            return;
        }
        if(condition.equals(Prize.SECOND)) {
            countSecond++;
            return;
        }
        if(condition.equals(Prize.THIRD)) {
            countThird++;
            return;
        }
        if(condition.equals(Prize.FOURTH)) {
            countFourth++;
            return;
        }
        if(condition.equals(Prize.FIFTH)) {
            countFifth++;
        }
    }
}

package lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lotto.constant.Prize;

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

    private void updateCounts(Prize prize) {
        if (prize.equals(Prize.FIRST)) {
            countFirst++;
            return;
        }
        if (prize.equals(Prize.SECOND)) {
            countSecond++;
            return;
        }
        if (prize.equals(Prize.THIRD)) {
            countThird++;
            return;
        }
        if (prize.equals(Prize.FOURTH)) {
            countFourth++;
            return;
        }
        if (prize.equals(Prize.FIFTH)) {
            countFifth++;
        }
    }
}

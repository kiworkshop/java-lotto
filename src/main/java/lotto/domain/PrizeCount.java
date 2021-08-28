package lotto.domain;

import lombok.Getter;
import lotto.constant.Prize;

@Getter
public class PrizeCount {
    private final int[] prizeCounter = new int[6];

    public PrizeCount(LottoSet lottoset, WinningLotto winningLotto) {
        for (Lotto lotto : lottoset.getLottoSet()) {
            updateCounts(winningLotto.findPrize(lotto));
        }
    }

    private void updateCounts(Prize condition) {
        plusEachPrizeCount(condition.ordinal());
    }

    private void plusEachPrizeCount(int input) {
        prizeCounter[input] ++ ;
    }

    public int returnEachPrizeCount(int prizeOrder) {
        return prizeCounter[prizeOrder];
    }
}

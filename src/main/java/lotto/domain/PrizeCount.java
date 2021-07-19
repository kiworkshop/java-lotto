package lotto.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PrizeCount {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    @Builder
    public PrizeCount(LottoSet lottoset, WinningLotto winningLotto) {
        for (Lotto lotto : lottoset.getLottoSet()) {
            updateCounts(winningLotto.findPrizeCondition(lotto));
        }
    }

    private void updateCounts(Prize prize) {
        if (prize == Prize.FIRST) {
            first++;
            return;
        }
        if (prize == Prize.SECOND) {
            second++;
            return;
        }
        if (prize == Prize.THIRD) {
            third++;
            return;
        }
        if (prize == Prize.FOURTH) {
            fourth++;
            return;
        }
        if (prize == Prize.FIFTH) {
            fifth++;
        }
    }
}

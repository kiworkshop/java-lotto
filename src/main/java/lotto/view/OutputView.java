package lotto.view;

import lotto.domain.LottoSet;
import lotto.domain.PurchaseCount;
import lotto.domain.dto.LottoResult;

public interface OutputView {
    void askPurchaseCost();

    void printLottoCount(PurchaseCount purchaseCount);

    void printLottoSet(LottoSet LottoSet);

    void askWinningLottoNumbers();

    void askWinningLottoBonus();

    void printLottoStatistic(LottoResult lottoResult);

    void printException(String message);
}

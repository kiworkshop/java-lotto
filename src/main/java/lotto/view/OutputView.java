package lotto.view;

import lotto.domain.PurchaseCount;
import lotto.domain.RandomLottoSet;
import lotto.domain.dto.StatisticsResultDTO;

public interface OutputView {
    void askPurchaseCost();

    void printLottoCount(PurchaseCount purchaseCount);

    void printLottoSet(RandomLottoSet randomLottoSet);

    void askWinningLottoNumbers();

    void askWinningLottoBonus();

    void printLottoStatistic(StatisticsResultDTO statisticsResultDTO);

    void printException(String message);
}

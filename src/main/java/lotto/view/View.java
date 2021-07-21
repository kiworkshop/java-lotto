package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseCount;
import lotto.domain.LottoSet;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;

public class View {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static PurchasePriceInputDTO getPurchaseCost() {
        return inputView.getPurchaseCost();
    }

    public static WinningLottoInputDTO getWinningLottoAndBonus() {
        return inputView.getWinningLottoAndBonus();
    }

    public static void printLottoCount(PurchaseCount purchaseCount) {
        outputView.printLottoCount(purchaseCount);
    }

    public static void printLottoSet(LottoSet lottoSet) {
        outputView.printLottoSet(lottoSet);
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        outputView.printLottoStatistic(lottoStatistics);
    }
}

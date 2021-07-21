package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseCount;
import lotto.domain.LottoSet;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;

public class View {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public PurchasePriceInputDTO getPurchaseCost() {
        return inputView.getPurchaseCost();
    }

    public WinningLottoInputDTO getWinningLottoAndBonus() {
        return inputView.getWinningLottoAndBonus();
    }

    public void printLottoCount(PurchaseCount purchaseCount) {
        outputView.printLottoCount(purchaseCount);
    }

    public void printLottoSet(LottoSet lottoSet) {
        outputView.printLottoSet(lottoSet);
    }

    public void printLottoStatistics(LottoStatistics lottoStatistics) {
        outputView.printLottoStatistic(lottoStatistics);
    }
}

package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseCount;
import lotto.domain.RandomLottoSet;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;

public class View {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static PurchasePriceInputDTO getPurchaseCost() {
        outputView.askPurchaseCost();
        String purchaseCountInput = inputView.getPurchaseCost();

        return new PurchasePriceInputDTO(purchaseCountInput);
    }

    public static WinningLottoInputDTO getWinningLottoAndBonus() {
        outputView.askWinningLottoNumbers();
        String winningLottoNumbers = inputView.getWinningLottoNumbers();

        outputView.askWinningLottoBonus();
        String winningLottoBonus = inputView.getWinningLottoBonus();

        return new WinningLottoInputDTO(winningLottoNumbers, winningLottoBonus);
    }

    public static void printLottoCount(PurchaseCount purchaseCount) {
        outputView.printLottoCount(purchaseCount);
    }

    public static void printLottoSet(RandomLottoSet lottoSet) {
        outputView.printLottoSet(lottoSet);
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        outputView.printLottoStatistic(lottoStatistics);
    }
}

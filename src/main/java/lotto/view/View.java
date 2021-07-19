package lotto.view;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.StatisticsResult;
import lotto.domain.dto.WinningLottoInput;

@RequiredArgsConstructor
@Builder
public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public PurchasePriceInput getPurchaseCost() {
        outputView.askPurchaseCost();
        String purchaseCountInput = inputView.getPurchaseCost();

        return PurchasePriceInput.builder()
                .input(purchaseCountInput)
                .build();
    }

    public WinningLottoInput getWinningLottoAndBonus() {
        outputView.askWinningLottoNumbers();
        String winningLottoNumbers = inputView.getWinningLottoNumbers();

        outputView.askWinningLottoBonus();
        String winningLottoBonus = inputView.getWinningLottoBonus();

        return WinningLottoInput.builder()
                .winningLottoNumbers(winningLottoNumbers)
                .winningLottoBonus(winningLottoBonus)
                .build();
    }

    public void printLottoStatistics(StatisticsResult statisticsResult) {
        outputView.printLottoStatistic(statisticsResult);
    }

    public void printException(String message) {
        outputView.printException(message);
    }

    public void printLottoPurchaseResult(PurchaseResult purchaseResult) {
        outputView.printLottoCount(purchaseResult.getPurchaseCount());
        outputView.printLottoSet(purchaseResult.getLottoSet());
    }
}

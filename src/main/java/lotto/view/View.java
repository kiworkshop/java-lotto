package lotto.view;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lotto.domain.dto.PurchasePriceInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.StatisticsResult;
import lotto.domain.dto.WinningLottoInput;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public PurchasePriceInput getPurchaseCost() throws NumberFormatException {
        outputView.askPurchaseCost();
        Integer purchaseCountInput = inputView.getPurchaseCost();

        return PurchasePriceInput.builder()
                .price(purchaseCountInput)
                .build();
    }

    public WinningLottoInput getWinningLottoAndBonus() throws NumberFormatException {
        outputView.askWinningLottoNumbers();
        List<Integer> numbers = inputView.getWinningLottoNumbers();

        outputView.askWinningLottoBonus();
        Integer bonus = inputView.getWinningLottoBonus();

        return WinningLottoInput.builder()
                .numbers(numbers)
                .bonus(bonus)
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

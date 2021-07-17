package lotto.view;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.PurchaseResultDTO;
import lotto.domain.dto.StatisticsResultDTO;
import lotto.domain.dto.WinningLottoInputDTO;

@RequiredArgsConstructor
@Builder
public class View {

    private final InputView inputView;
    private final OutputView outputView;

    public PurchasePriceInputDTO getPurchaseCost() {
        outputView.askPurchaseCost();
        String purchaseCountInput = inputView.getPurchaseCost();

        return PurchasePriceInputDTO.builder()
                .input(purchaseCountInput)
                .build();
    }

    public WinningLottoInputDTO getWinningLottoAndBonus() {
        outputView.askWinningLottoNumbers();
        String winningLottoNumbers = inputView.getWinningLottoNumbers();

        outputView.askWinningLottoBonus();
        String winningLottoBonus = inputView.getWinningLottoBonus();

        return WinningLottoInputDTO.builder()
                .winningLottoNumbers(winningLottoNumbers)
                .winningLottoBonus(winningLottoBonus)
                .build();
    }

    public void printLottoStatistics(StatisticsResultDTO statisticsResultDTO) {
        outputView.printLottoStatistic(statisticsResultDTO);
    }

    public void printException(String message) {
        outputView.printException(message);
    }

    public void printLottoPurchaseResult(PurchaseResultDTO purchaseResultDTO) {
        outputView.printLottoCount(purchaseResultDTO.getPurchaseCount());
        outputView.printLottoSet(purchaseResultDTO.getRandomLottoSet());
    }
}

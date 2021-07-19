package lotto;

import lotto.controller.LottoController;
import lotto.domain.dto.LottoResult;
import lotto.domain.dto.PurchaseInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.WinningLottoInput;
import lotto.exception.ExceptionMessage;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.View;

public class LottoApplication {

    public static void main(String[] args) {
        View view = new View(new ConsoleInputView(), new ConsoleOutputView());
        LottoController lottoController = new LottoController();

        try {
            PurchaseInput purchaseInput = view.getPurchasePrice();
            PurchaseResult purchaseResult = lottoController.purchase(purchaseInput);
            view.printLottoPurchaseResult(purchaseResult);

            WinningLottoInput winningLottoInput = view.getWinningLottoAndBonus();
            LottoResult lottoResult = lottoController.calculateResult(purchaseResult, winningLottoInput);
            view.printLottoStatistics(lottoResult);
        } catch (NumberFormatException e) {
            view.printException(ExceptionMessage.NON_NUMBER_INPUT.getMessage());
        } catch (IllegalArgumentException e) {
            view.printException(e.getMessage());
        }
    }
}

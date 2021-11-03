package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();

            BuyingPrice buyingPrice = lottoController.getBuyingPrice(InputView.getBuyingPrice());
            TicketAmount ticketAmount = lottoController.getTicketAmount(buyingPrice.totalTicketAmount(), InputView.getManualCount());

            LottoTickets lottoTickets = lottoController.issueTickets(ticketAmount);
            OutputView.printTicketAmount(ticketAmount);
            OutputView.printLottoTickets(lottoTickets);

            String winningNumber = InputView.getWinningNumber();
            String bonusNumber = InputView.getBonusNumber();
            WinningNumbers winningNumbers = lottoController.validateWinningLottoNumbers(winningNumber, bonusNumber);
            float profitRate = lottoController.calculateProfitRate(ticketAmount.total(), lottoTickets, winningNumbers);
            OutputView.printProfitRate(profitRate);

        } catch (RuntimeException e) {
            System.out.println("=====> Error Message : " + e.getMessage());
        }
    }
}


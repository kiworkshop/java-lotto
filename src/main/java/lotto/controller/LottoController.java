package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.util.StringUtil;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static final LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

    public static void run() {
        String inputPrice = InputView.getBuyingPrice();
        BuyingPrice buyingPrice = new BuyingPrice(inputPrice);

        String inputManualCount = InputView.getManualCount();
        TicketAmount ticketAmount = new TicketAmount(buyingPrice, inputManualCount);

        List<String> inputManualNumbers = InputView.getManualNumbers(ticketAmount);
        LottoTickets lottoTickets = lottoTicketVendingMachine.issueTickets(ticketAmount, inputManualNumbers);

        OutputView.printTicketAmount(ticketAmount);
        OutputView.printLottoTickets(lottoTickets);

        String inputWinningNumbers = InputView.getWinningNumber();
        List<Integer> splitWinningNumbers = StringUtil.splitParseInt(inputWinningNumbers);

        int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(splitWinningNumbers, bonusNumber);
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
        OutputView.printWinningStatistics(winningLottoRank);

        WinningStatistics winningStatistics = new WinningStatistics(winningLottoRank);
        float profitRate = winningStatistics.profitRate(ticketAmount);
        OutputView.printProfitRate(profitRate);
    }
}

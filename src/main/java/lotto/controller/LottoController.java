package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.util.StringUtil;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void run() {
        try {
            String inputPrice = InputView.getBuyingPrice();
            String inputManualCount = InputView.getManualCount();

            BuyingPrice buyingPrice = new BuyingPrice(inputPrice);
            TicketAmount ticketAmount = new TicketAmount(buyingPrice, inputManualCount);

            List<String> inputManualNumbers = InputView.getManualNumbers(ticketAmount);
            LottoTickets lottoTickets = lottoService.issueTickets(ticketAmount, inputManualNumbers);

            OutputView.printTicketAmount(ticketAmount);
            OutputView.printLottoTickets(lottoTickets);

            String inputWinningNumbers = InputView.getWinningNumber();
            List<Integer> splitWinningNumbers = StringUtil.splitParseInt(inputWinningNumbers);

            WinningLottoRank winningLottoRank = lottoService.getWinningLottoRank(lottoTickets, splitWinningNumbers);
            float profitRate = lottoService.getProfitRate(ticketAmount, winningLottoRank);

            OutputView.printProfitRate(profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}

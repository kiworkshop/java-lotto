package lotto.controller;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.LottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private static LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

    public static void run() {
        String inputPrice = InputView.getBuyingPrice();
        BuyingPrice buyingPrice = new BuyingPrice(inputPrice);

        String inputManualCount = InputView.getManualCount();
        TicketAmount ticketAmount = new TicketAmount(buyingPrice, inputManualCount);

        List<String> manualNumbers = InputView.getManualNumbers(ticketAmount);
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            List<LottoNumber> manualLottoNumbers = InputView.split(manualNumber).stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            manualLottoTickets.add(new LottoTicket(manualLottoNumbers));
        }

        List<LottoTicket> autoLottoTickets = lottoTicketVendingMachine.autoIssueTickets(ticketAmount);
        OutputView.printTicketAmount(ticketAmount);

        List<LottoTicket> lottoTickets = Stream.concat(manualLottoTickets.stream(), autoLottoTickets.stream())
                .collect(Collectors.toList());

        String inputWinningNumbers = InputView.getWinningNumber();
        List<Integer> splitWinningNumbers = InputView.split(inputWinningNumbers)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(splitWinningNumbers, bonusNumber);
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);

        Map<LottoRank, Integer> ranks = winningStatistics.groupByHitCount(lottoTickets);
        OutputView.printWinningStatistics(ranks);

        float profitRate = winningStatistics.profitRate(ticketAmount, ranks);
        OutputView.printProfitRate(profitRate);
    }
}

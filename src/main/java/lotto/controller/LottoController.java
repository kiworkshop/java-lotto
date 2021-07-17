package lotto.controller;

import lotto.domain.LottoTicketGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
import lotto.domain.dto.request.NumberOfTicketsRequest;
import lotto.domain.dto.request.WinningStatisticsRequest;
import lotto.domain.dto.response.LottoTicketsResponse;
import lotto.domain.dto.response.NumberOfTicketsResponse;
import lotto.domain.dto.response.WinningStatisticsResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {
        NumberOfTickets numberOfTickets = getNumberOfTickets(InputView.inputPurchaseAmount());
        LottoTickets lottoTickets = createLottoTickets(numberOfTickets);
        showWinningStatistics(InputView.inputWinningNumbers(), InputView.inputBonusNumber(), numberOfTickets, lottoTickets);
    }

    private NumberOfTickets getNumberOfTickets(String inputPurchaseAmount) {
        NumberOfTicketsRequest numberOfTicketsRequest = new NumberOfTicketsRequest(inputPurchaseAmount);
        PurchaseAmount purchaseAmount = new PurchaseAmount(numberOfTicketsRequest.getPurchaseAmount());
        NumberOfTickets numberOfTickets = purchaseAmount.convertToNumberOfTickets();
        NumberOfTicketsResponse numberOfTicketsResponse = new NumberOfTicketsResponse(numberOfTickets.intValue());
        OutputView.printNumberOfTickets(numberOfTicketsResponse);
        return numberOfTickets;
    }

    private LottoTickets createLottoTickets(NumberOfTickets numberOfTickets) {
        LottoTickets lottoTickets = LottoTicketGenerator.createAutoTickets(numberOfTickets);
        LottoTicketsResponse lottoTicketsResponse = new LottoTicketsResponse(lottoTickets.list());
        OutputView.printLottoTickets(lottoTicketsResponse);
        return lottoTickets;
    }

    private void showWinningStatistics(List<String> inputWinnningNumbers, String inputBonusNumber, NumberOfTickets numberOfTickets, LottoTickets lottoTickets) {
        WinningStatisticsRequest winningStatisticsRequest = new WinningStatisticsRequest(inputWinnningNumbers, inputBonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(winningStatisticsRequest.getWinningNumbers(), winningStatisticsRequest.getBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(lottoTickets.match(winningNumbers));
        WinningStatisticsResponse winningStatisticsResponse = new WinningStatisticsResponse(winningStatistics.getRanks(), winningStatistics.calculateProfit(numberOfTickets));
        OutputView.printWinningStatistics(winningStatisticsResponse);
    }
}

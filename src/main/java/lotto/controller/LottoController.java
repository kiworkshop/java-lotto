package lotto.controller;

import static lotto.util.InputUtil.*;

import java.util.List;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.service.StatisticService;
import lotto.service.TicketService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoController {
  private TicketService ticketService = new TicketService();
  private StatisticService statisticService = new StatisticService();

  public void run(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
    int totalPrice = parseStringToInt(consoleInputView.getPriceInput());
    int numOfManualLotto = parseStringToInt(consoleInputView.getNumOfManualLotto());
    LottoPurchase lottoPurchase = LottoPurchase.of(totalPrice, numOfManualLotto);

    // TODO: 2020-02-15 service로 분리
    List<LottoTicket> manualLottoTickets = ticketService.toLottoTickets(
        consoleInputView.getManualLottoNumbers(numOfManualLotto));
    List<LottoTicket> autoLottoTickets = ticketService.generateLottoTickets(lottoPurchase);
    LottoTickets lottoTickets = LottoTickets.of(manualLottoTickets, autoLottoTickets);

    consoleOutputView.showLottoTickets(lottoTickets);

    String lastWinningNumbersInput = consoleInputView.getWinningNumbers();
    List<Integer> winningNumbers = ticketService.generateWinningTicket(lastWinningNumbersInput);
    consoleOutputView.showResult(statisticService.calculateResult(lottoTickets, winningNumbers));
  }
}

package lotto.controller;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.service.StatisticService;
import lotto.service.TicketService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoController {
  private TicketService ticketService = new TicketService();
  private StatisticService statisticService = new StatisticService();

  public void run(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
    int priceForTickets = consoleInputView.getPriceInput();
    List<LottoTicket> lottoTickets = ticketService.generateLottoTickets(priceForTickets);
    consoleOutputView.showLottoTickets(lottoTickets);

    String lastWinningNumbersInput = consoleInputView.getWinningNumbers();
    List<Integer> winningNumbers = ticketService.generateWinningTicket(lastWinningNumbersInput);
    consoleOutputView.showResult(statisticService.calculateResult(lottoTickets, winningNumbers));
  }
}

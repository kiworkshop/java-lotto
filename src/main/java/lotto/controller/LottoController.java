package lotto.controller;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.service.StatisticService;
import lotto.service.TicketService;
import lotto.view.ConsoleInputView;

public class LottoController {
  private TicketService ticketService = new TicketService();
  private StatisticService statisticService = new StatisticService();

  public void run(ConsoleInputView consoleInputView) {
    int priceForTickets = consoleInputView.getPriceInput();
    List<LottoTicket> lottoTickets = ticketService.generateLottoTickets(priceForTickets);


  }
}

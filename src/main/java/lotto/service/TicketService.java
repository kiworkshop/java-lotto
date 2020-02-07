package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;

public class TicketService {
  private static final int TICKET_PRICE = 1000;

  public List<LottoTicket> generateLottoTickets(int totalPrice) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numOfTickets(totalPrice); i++) {
      lottoTickets.add(LottoTicket.of());
    }
    return lottoTickets;
  }

  private int numOfTickets(int totalPrice) {
    return totalPrice / TICKET_PRICE;
  }
}

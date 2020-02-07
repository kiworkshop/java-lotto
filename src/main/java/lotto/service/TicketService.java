package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoTicket;

public class TicketService {
  private static final int TICKET_PRICE = 1000;
  private static final String INPUT_DELIMITER = ",";

  public List<LottoTicket> generateLottoTickets(int totalPrice) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < numOfTickets(totalPrice); i++) {
      lottoTickets.add(LottoTicket.ofRandom());
    }
    return lottoTickets;
  }

  private int numOfTickets(int totalPrice) {
    return totalPrice / TICKET_PRICE;
  }

  public List<Integer> generateWinningTicket(String lastWinningNumbersInput) {
    return Arrays.asList(lastWinningNumbersInput.split(INPUT_DELIMITER)).stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}

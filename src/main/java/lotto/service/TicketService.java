package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

public class TicketService {
  private static final String INPUT_DELIMITER = ",";

  public List<LottoTicket> toLottoTickets(List<String> lottoNumbersInput) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (String lotto : lottoNumbersInput) {
      lottoTickets.add(LottoTicket.of(Arrays.asList(lotto.split(INPUT_DELIMITER))));
    }
    return lottoTickets;
  }

  public List<LottoTicket> generateLottoTickets(LottoPurchase purchase) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    for (int i = 0; i < purchase.numOfAutoTickets(); i++) {
      lottoTickets.add(LottoTicket.ofRandom());
    }
    return lottoTickets;
  }

  public WinningLotto generateWinningLotto(String lastWinningNumbersInput, int bonusBall) {
    List<Integer> winningNumbers = Arrays.asList(lastWinningNumbersInput.split(INPUT_DELIMITER)).stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return WinningLotto.of(winningNumbers, bonusBall);
  }
}

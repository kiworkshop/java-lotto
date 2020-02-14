package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Prizes;

public class StatisticService {

  public Prizes calculateResult(LottoTickets lottoTickets, List<Integer> winningNumbers) {
    List<Integer> numOfMatches = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
      numOfMatches.add(lottoTicket.calculateNumOfMatch(winningNumbers));
    }
    return new Prizes(numOfMatches);
  }
}
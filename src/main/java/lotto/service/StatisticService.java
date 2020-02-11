package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.Prizes;

public class StatisticService {

  public Prizes calculateResult(List<LottoTicket> lottoTickets, List<Integer> winningNumbers) {
    List<Integer> numOfMatches = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets) {
      numOfMatches.add(lottoTicket.calculateNumOfMatch(winningNumbers));
    }
    return new Prizes(numOfMatches);
  }
}
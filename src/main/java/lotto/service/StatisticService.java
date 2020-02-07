package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.StatisticResult;

public class StatisticService {

  public StatisticResult calculateResult(List<LottoTicket> lottoTickets, List<Integer> winningNumbers, int price) {
    List<Integer> numOfMatches = new ArrayList<>();
    for (LottoTicket lottoTicket : lottoTickets) {
      numOfMatches.add(lottoTicket.calculateNumOfMatch(winningNumbers));
    }
    return new StatisticResult(numOfMatches, price);
  }
}
package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
  private List<Integer> winningNumbers;
  private int bonusBall;

  private WinningLotto(List<Integer> winningNumbers, int bonusBall) {
    this.winningNumbers = winningNumbers;
    this.bonusBall = bonusBall;
  }

  public static WinningLotto of(List<Integer> winningNumbers, int bonusBall) {
    return new WinningLotto(winningNumbers, bonusBall);
  }

  public Prizes calculateResult(LottoTickets lottoTickets) {
    List<Integer> numOfMatches = new ArrayList<>();
    boolean bonusMatch = false;
    for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
      numOfMatches.add(lottoTicket.calculateNumOfMatch(winningNumbers));
      bonusMatch = lottoTicket.hasMatchingNumWith(bonusBall);
    }
    return new Prizes(numOfMatches, bonusMatch);
  }
}

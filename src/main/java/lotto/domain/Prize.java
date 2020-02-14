package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
  FIRST(6, 2000000000, false),
  SECOND(5, 30000000, true),
  THIRD(5, 1500000, false),
  FORTH(4, 50000, false),
  FIFTH(3, 5000, false),
  LOSING(0, 0, false);

  private int numOfMatches;
  private int winningMoney;
  private boolean bonusMatch;

  Prize(int numOfMatches, int winningMoney, boolean bonusMatch) {
    this.numOfMatches = numOfMatches;
    this.winningMoney = winningMoney;
    this.bonusMatch = bonusMatch;
  }

  public static Prize getPrizeFrom(int numOfMatches, boolean bonusMatched) {
    return Arrays.stream(Prize.values())
        .filter(prize -> prize.numOfMatches == numOfMatches)
        .findAny()
        .orElse(LOSING);
  }

  public static List<Prize> valuesOfProfit() {
    Prize[] prizes = Prize.values();
    return Arrays.stream(prizes)
        .filter(prize -> prize.winningMoney > 0)
        .collect(Collectors.toList());
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public void showMatchesAndMoney() {
    if (bonusMatch) {
      System.out.print(numOfMatches + "개 일치, 보너스볼 일치(" + winningMoney + "원) - ");
    }
    System.out.print(numOfMatches + "개 일치 (" + winningMoney + "원) - ");
  }

}

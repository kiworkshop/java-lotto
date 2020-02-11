package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FORTH(3, 5000),
  LOSING(0, 0);

  private int numOfMatches;
  private int winningMoney;

  Prize(int numOfMatches, int winningMoney) {
    this.numOfMatches = numOfMatches;
    this.winningMoney = winningMoney;
  }

  public static Prize getPrizeFrom(int numOfMatches) {
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
    System.out.print(numOfMatches + "개 일치 (" + winningMoney + "원) - ");
  }

}

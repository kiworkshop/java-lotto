package lotto.domain;

import java.util.List;

import lotto.domain.prize.FirstPrize;
import lotto.domain.prize.ForthPrize;
import lotto.domain.prize.SecondPrize;
import lotto.domain.prize.ThirdPrize;

public class StatisticResult {
  private FirstPrize firstPrize = new FirstPrize();
  private SecondPrize secondPrize = new SecondPrize();
  private ThirdPrize thirdPrize = new ThirdPrize();
  private ForthPrize forthPrize = new ForthPrize();
  private int ticketPrice;

  public StatisticResult(List<Integer> numOfMatches, int price) {
    for (Integer numOfMatch : numOfMatches) {
      switch (numOfMatch) {
        case 3:
          forthPrize.add();
          break;
        case 4:
          thirdPrize.add();
          break;
        case 5:
          secondPrize.add();
          break;
        case 6:
          firstPrize.add();
          break;
      }
    }
    this.ticketPrice = price;
  }

  public long getEarningRate() {
    return firstPrize.getTotalMoney() + secondPrize.getTotalMoney() + thirdPrize.getTotalMoney()
        + forthPrize.getTotalMoney() / ticketPrice;
  }

  public void showMatches() {
    firstPrize.show();
    secondPrize.show();
    thirdPrize.show();
    forthPrize.show();
  }
}

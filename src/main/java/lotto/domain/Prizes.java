package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
  private static final int TICKET_PRICE = 1000;
  private List<Prize> prizes;

  public Prizes(List<Integer> numOfMatches) {
    this.prizes = numOfMatches.stream()
        .map(Prize::getPrizeFrom)
        .collect(Collectors.toList());
  }

  public long getEarningRate() {
    int totalWinningMoney = prizes.stream()
        .mapToInt(Prize::getWinningMoney)
        .sum();
    return (totalWinningMoney - getPurchasePrice()) / getPurchasePrice() * 100;
  }

  public int getPurchasePrice() {
    return TICKET_PRICE * prizes.size();
  }

  private int count(Prize prize) {
    return (int) this.prizes.stream().filter(prize::equals).count();
  }

  public void showStat() {
    Prize.valuesOfProfit().forEach(prize -> {
      prize.showMatchesAndMoney();
      System.out.println(count(prize) + "개");
    });
  }

}

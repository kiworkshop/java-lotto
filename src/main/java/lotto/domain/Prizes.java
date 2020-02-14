package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
  private static final int TICKET_PRICE = 1000;
  private List<Prize> prizes = new ArrayList<>();

  public Prizes(List<Integer> numOfMatches, boolean bonusMatch) {
    for (Integer numOfMatch : numOfMatches) {
      prizes.add(Prize.getPrizeFrom(numOfMatch, bonusMatch));
    }
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

  public void showStat() {
    Prize.valuesOfProfit().forEach(prize -> {
      prize.showMatchesAndMoney();
      showCount(prize);
    });
  }

  private void showCount(Prize prize) {
    System.out.println(count(prize) + "개");
  }

  private int count(Prize prize) {
    return (int) this.prizes.stream().filter(prize::equals).count();
  }

}

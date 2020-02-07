package lotto.domain.prize;

public class ForthPrize extends Prize {
  private static final int PRIZE_MONEY = 5000;
  private static final int MATCHES = 3;

  public int getTotalMoney() {
    return PRIZE_MONEY * count;
  }

  public int getCount() {
    return count;
  }

  public void add() {
    count++;
  }

  public void show() {
    System.out.println(MATCHES + "개 일치 (" + PRIZE_MONEY + "원) - " + count + "개");
  }
}

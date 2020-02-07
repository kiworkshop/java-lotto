package lotto.domain.prize;

public class FirstPrize extends Prize {
  private static final int PRIZE_MONEY = 2000000000;
  private static final int MATCHES = 6;

  public int getTotalMoney() {
    return PRIZE_MONEY * super.count;
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

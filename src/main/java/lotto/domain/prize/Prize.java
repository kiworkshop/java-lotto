package lotto.domain.prize;

public abstract class Prize {
  protected int count;
  abstract int getTotalMoney();
  abstract int getCount();
  abstract void add();
  abstract void show();
}

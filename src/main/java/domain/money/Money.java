package domain.money;

public class Money {

    private static int PRICE_PER_LOTTO = 1000;

    private int money;

    public static Money from(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        if (money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException();
        }
        return new Money(money);
    }

    private Money(int money) {
        this.money = money;
    }

    public int getCountOfLotto() {
        return money / PRICE_PER_LOTTO;
    }
}

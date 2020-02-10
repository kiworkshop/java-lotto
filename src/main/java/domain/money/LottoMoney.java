package domain.money;

public class LottoMoney {

    private static int PRICE_PER_LOTTO = 1000;

    private int money;

    public static LottoMoney from(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        if (money % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException();
        }
        return new LottoMoney(money);
    }

    private LottoMoney(int money) {
        this.money = money;
    }

    public int getCountOfLotto() {
        return money / PRICE_PER_LOTTO;
    }
}

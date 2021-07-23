package domain;

public class PurchaseMoney {

    private int money;
    private static final int MIN_VALUE = 1_000;

    public PurchaseMoney(int money) {
        if (money < MIN_VALUE) {
            throw new IllegalArgumentException("로또 구입을 위해서는 최소 1000원이 필요합니다.");
        }

        this.money = money;
    }

}

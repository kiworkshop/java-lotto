package lottogame.domain;

public class MoneyAmount {

    private static final int MIN_MONEY_AMOUNT = 1000;
    private static final int ONE_LOTTO_PRICE = 1000;

    private final int moneyAmount;

    public MoneyAmount(final int moneyAmount) {
        this.moneyAmount = moneyAmount;

        if (moneyAmount < MIN_MONEY_AMOUNT
                || !isMultipleOfOneLottoPrice()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMultipleOfOneLottoPrice() {
        return (moneyAmount % ONE_LOTTO_PRICE) == 0;
    }

    public int calculateLottoCount() {
        return moneyAmount / ONE_LOTTO_PRICE;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }
}

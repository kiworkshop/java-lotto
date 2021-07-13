package lotto.domain;

import java.util.Objects;

public class BuyingPrice {
    public static final int TICKET_PRICE = 1000;

    private final int buyingPrice;

    public BuyingPrice(final int buyingPrice) {
        validate(buyingPrice);
        this.buyingPrice = buyingPrice;
    }

    public BuyingPrice(String buyingPrice) {
        this(Integer.parseInt(buyingPrice));
    }

    private void validate(int buyingPrice) {
        validateMinimum(buyingPrice);
        validateDivisible(buyingPrice);
    }

    private void validateMinimum(int buyingPrice) {
        if (buyingPrice < TICKET_PRICE) {
            throw new IllegalArgumentException("구입 금액은 "+ TICKET_PRICE +"원 이상이여야 합니다.");
        }
    }

    private void validateDivisible(int buyingPrice) {
        if ((buyingPrice % TICKET_PRICE) != 0) {
            throw new IllegalArgumentException("구입 금액은 "+ TICKET_PRICE +"원 단위여야 합니다.");
        }
    }

    public int ticketAmount() {
        return buyingPrice / TICKET_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyingPrice that = (BuyingPrice) o;
        return buyingPrice == that.buyingPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyingPrice);
    }
}

package lotto.domain;

import lombok.Builder;
import lombok.Getter;

import static lotto.exception.ExceptionMessage.LESS_THAN_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY;
import static lotto.exception.ExceptionMessage.NON_MULTIPLE_OF_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY;

public class PurchaseCount {

    private static final int MINIMUM_INPUT = 1000;

    @Getter
    private final Integer purchaseCount;

    @Builder
    public PurchaseCount(int purchasePrice) {
        validate(purchasePrice);

        this.purchaseCount = purchasePrice / Lotto.PRICE;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice < MINIMUM_INPUT) {
            throw new IllegalArgumentException(LESS_THAN_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY.getMessage());
        }
        if (notMultipleOfLottoPrice(purchasePrice)) {
            throw new IllegalArgumentException(NON_MULTIPLE_OF_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY.getMessage());
        }
    }

    private boolean notMultipleOfLottoPrice(int input) {
        return input % Lotto.PRICE != 0;
    }
}

package lotto.domain;

import lombok.Builder;
import lombok.Getter;

import static lotto.exception.ExceptionMessage.NEGATIVE_INTEGER_INPUT_FOR_PURCHASE_MONEY;
import static lotto.exception.ExceptionMessage.NON_MULTIPLE_OF_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY;
import static lotto.util.NumberValidateUtils.isNonNegativeInteger;

public class PurchaseCount {

    private static final int MINIMUM_INPUT = 1000;

    @Getter
    private final int purchaseCount;

    @Builder
    public PurchaseCount(String input) {
        input = input.trim();
        validate(input);

        this.purchaseCount = Integer.parseInt(input) / Lotto.PRICE;
    }

    private void validate(String input) {
        if (!isNonNegativeInteger(input)) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_INPUT_FOR_PURCHASE_MONEY.getMessage());
        }

        int purchaseCount = Integer.parseInt(input);
        if (notMatchesCondition(purchaseCount)) {
            throw new IllegalArgumentException(NON_MULTIPLE_OF_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY.getMessage());
        }
    }

    private boolean notMatchesCondition(int input) {
        return input < MINIMUM_INPUT || notMultipleOfLottoPrice(input);
    }

    private boolean notMultipleOfLottoPrice(int input) {
        return input % Lotto.PRICE != 0;
    }
}

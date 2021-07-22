package lotto.domain;

import lombok.Getter;
import lotto.util.NumberValidateUtils;

public class PurchaseCount {

    private static final int MINIMUM_INPUT = 1000;

    @Getter
    private final int purchaseCount;

    public PurchaseCount(String input) {
        input = input.trim();
        validate(input);
        this.purchaseCount = Integer.parseInt(input) / Lotto.PRICE;
    }

    private void validate(String input) {
        NumberValidateUtils.numericCheck(input);
        int inputConversion = Integer.parseInt(input);
        if (notMatchesCondition(inputConversion)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input < MINIMUM_INPUT || notMultipleOfStandard(input);
    }

    private boolean notMultipleOfStandard(int input) {
        return input % Lotto.PRICE != 0;
    }
}

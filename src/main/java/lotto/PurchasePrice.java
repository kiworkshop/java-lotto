package lotto;

import java.util.regex.Pattern;

public class PurchasePrice {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MINIMUM_INPUT = 1000;
    private static final int STANDARD = 1000;

    private final int purchasePrice;

    public PurchasePrice(String input) {
        input = input.trim();
        validate(input);
        this.purchasePrice = Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
        int inputConversion = Integer.parseInt(input);
        if (notMatchesCondition(inputConversion)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input < MINIMUM_INPUT || notMultipleOfStandard(input);
    }

    private boolean notMultipleOfStandard(int input) {
        return input % STANDARD != 0;
    }
}

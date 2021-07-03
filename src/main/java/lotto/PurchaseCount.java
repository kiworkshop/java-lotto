package lotto;

import lombok.Getter;

import java.util.regex.Pattern;

public class PurchaseCount {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MINIMUM_INPUT = 1000;
    private static final int STANDARD = 1000;

    @Getter
    private final int purchaseCount;

    public PurchaseCount(String input) {
        input = input.trim();
        validate(input);
        this.purchaseCount = Integer.parseInt(input)/STANDARD;
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

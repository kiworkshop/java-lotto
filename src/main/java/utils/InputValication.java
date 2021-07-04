package utils;

import java.util.regex.Pattern;

public class InputValication {
    private static final String LOTTO_PRICE_PATTERN = "\\d*000";
    public int checkGivenMoeny(String givenMoney) {
        if(!Pattern.matches(LOTTO_PRICE_PATTERN, givenMoney)){
            throw new RuntimeException("1000원 단위의 금액만 투입할 수 있습니다.");
        }
        return Integer.parseInt(givenMoney);
    }
}

package lotto.util;

import java.util.regex.Pattern;

public class NumberValidateUtils {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isInteger(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

    public static String numericCheck(String input) {
        if(!isInteger(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        return input;
    }

    public static int parseLottoNumber(String input) {
        numericCheck(input);
        return Integer.parseInt(input);
    }

}

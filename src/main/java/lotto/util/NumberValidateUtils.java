package lotto.util;

import java.util.regex.Pattern;

public class NumberValidateUtils {

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isNonNegativeInteger(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }
}

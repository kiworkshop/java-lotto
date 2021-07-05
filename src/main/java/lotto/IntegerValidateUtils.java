package lotto;

import java.util.regex.Pattern;

public class IntegerValidateUtils {
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public static boolean isNumber(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

}

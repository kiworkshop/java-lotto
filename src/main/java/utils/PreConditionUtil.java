package utils;

import org.apache.commons.lang3.StringUtils;

public class PreConditionUtil {

    private static final String ALERT_CHECK_NULL_OR_EMPTY = "null 또는 빈 값인지 확인해주세요.";

    private PreConditionUtil() {
    }

    public static void checkNullOrEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ALERT_CHECK_NULL_OR_EMPTY);
        }
    }
}

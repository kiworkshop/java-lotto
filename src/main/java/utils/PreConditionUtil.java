package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PreConditionUtil {

    private static final String ALERT_CHECK_NULL_OR_EMPTY = "null 또는 빈 값인지 확인해주세요.";
    private static final String COMMA = ",";
    private static final String ALERT_CHECK_COMMA = String.format("구분자를 \"%s\"로 입력하셨는지 확인해주세요.", COMMA);

    private PreConditionUtil() {
    }

    public static void checkNullOrEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ALERT_CHECK_NULL_OR_EMPTY);
        }
    }

    public static List<Integer> toIntegers(List<String> input) {
        return new ArrayList<>(input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public static List<String> splitByComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ALERT_CHECK_COMMA);
        }
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

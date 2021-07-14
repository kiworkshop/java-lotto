package lotto.domain.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private static final String DELIMITER = ",";

    public static List<String> split(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> splitParseInt(String input) {
        return split(input).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

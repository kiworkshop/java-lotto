package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static final String DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private StringUtil() {
    }

    public static List<String> split(String input) {
        List<String> splitStrings = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        if (splitStrings.size() > LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
        return splitStrings;
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> splitParseInt(String input) {
        try {
            return split(input).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }
}

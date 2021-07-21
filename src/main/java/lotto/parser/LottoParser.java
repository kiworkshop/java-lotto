package lotto.parser;

import lotto.domain.LottoNumber;
import lotto.util.NumberValidateUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private static final String DELIMITER = ",";

    public static List<LottoNumber> generateLotto(String numberInput) {
        return Arrays.stream(numberInput.split(DELIMITER))
                .map(String::trim)
                .map(NumberValidateUtils::numericCheck)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

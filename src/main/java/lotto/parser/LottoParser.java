package lotto.parser;

import lotto.domain.LottoNumber;
import lotto.util.NumberValidateUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private static final String DELIMITER = ",";

    public static List<LottoNumber> generateLotto(String numberInput) {
        String[] splitedNumberInput = numberInput.split(DELIMITER);
        lottoNumbersSizeCheck(splitedNumberInput);
        return Arrays.stream(splitedNumberInput)
                .map(String::trim)
                .mapToInt(NumberValidateUtils::parseLottoNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void lottoNumbersSizeCheck(String[] input) {
        if(input.length != 6) {
            throw new IllegalArgumentException("로또 번호 6개를 정확히 입력해주세요.");
        }
    }
}

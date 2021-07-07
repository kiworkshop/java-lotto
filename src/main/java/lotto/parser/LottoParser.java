package lotto.parser;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.exception.ExceptionMessage.INVALID_LENGTH_INPUT_FOR_WINNING_LOTTO;

public class LottoParser {

    private static final String DELIMITER = ",";

    public static List<LottoNumber> parseInputIntoLottoNumbers(String numberInput) throws IllegalArgumentException {
        List<LottoNumber> lottoNumbers = Arrays.stream(numberInput.split(DELIMITER))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        validate(lottoNumbers);

        return lottoNumbers;
    }

    private static void validate(List<LottoNumber> lottoNumbers) throws IllegalArgumentException {
        if (lottoNumbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT_FOR_WINNING_LOTTO.getMessage());
        }
    }
}

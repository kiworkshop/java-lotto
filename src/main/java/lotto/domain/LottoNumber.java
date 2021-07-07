package lotto.domain;

import lombok.Getter;

import java.util.Objects;

import static lotto.exception.ExceptionMessage.NON_INTEGER_INPUT_FOR_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.OUT_OF_BOUND_INPUT_FOR_LOTTO_NUMBER;
import static lotto.util.NumberValidateUtils.isInteger;

public class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    @Getter
    private final int lottoNumber;

    public LottoNumber(String input) throws IllegalArgumentException {
        validate(input);

        this.lottoNumber = Integer.parseInt(input);
    }

    private void validate(String input) throws IllegalArgumentException {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(NON_INTEGER_INPUT_FOR_LOTTO_NUMBER.getMessage());
        }

        int lottoNumber = Integer.parseInt(input);
        if (isOutOfBound(lottoNumber)) {
            throw new IllegalArgumentException(OUT_OF_BOUND_INPUT_FOR_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isOutOfBound(int lottoNumber) {
        return lottoNumber < LOWER_BOUND || lottoNumber > UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}

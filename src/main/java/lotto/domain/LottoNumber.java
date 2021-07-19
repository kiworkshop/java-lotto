package lotto.domain;

import lombok.Getter;

import java.util.Objects;

import static lotto.exception.ExceptionMessage.OUT_OF_BOUND_INPUT_FOR_LOTTO_NUMBER;

public class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    @Getter
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) throws IllegalArgumentException {
        validate(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) throws IllegalArgumentException {
        if (isOutOfBound(lottoNumber)) {
            throw new IllegalArgumentException(OUT_OF_BOUND_INPUT_FOR_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean isOutOfBound(int lottoNumber) {
        return lottoNumber < LOWER_BOUND || lottoNumber > UPPER_BOUND;
    }

    public boolean isGreaterThan(LottoNumber winningNumber) {
        return this.getLottoNumber() > winningNumber.getLottoNumber();
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

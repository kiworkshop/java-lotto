package lotto.domain;

import lombok.Getter;

import java.util.Objects;

public class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    @Getter
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumberBound(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumberBound(int input) {
        if (isOutOfBound(input)) {
            throw new IllegalArgumentException("1~45 값을 입력해주세요");
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

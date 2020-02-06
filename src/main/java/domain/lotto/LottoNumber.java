package domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private int lottoNumber;

    public static LottoNumber from(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        return new LottoNumber(lottoNumber);
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}

package domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 46;

    private int lottoNumber;

    public static LottoNumber from(int lottoNumber) {
        if (!isInLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException();
        }
        return new LottoNumber(lottoNumber);
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private static boolean isInLottoNumberRange(int lottoNumber) {
        return MINIMUM_LOTTO_NUMBER <= lottoNumber && lottoNumber <= MAXIMUM_LOTTO_NUMBER;
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

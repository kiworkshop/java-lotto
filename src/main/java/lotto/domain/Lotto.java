package lotto.domain;

import lombok.Getter;

import java.util.*;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;

    @Getter
    protected List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
        this.lottoNumbers = Collections.unmodifiableList(new ArrayList<>(lottoNumbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

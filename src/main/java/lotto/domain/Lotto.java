package lotto.domain;

import lombok.Getter;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;

    @Getter
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

}

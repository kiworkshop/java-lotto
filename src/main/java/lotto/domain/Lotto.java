package lotto.domain;

import lombok.Getter;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;

    @Getter
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}

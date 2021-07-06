package lotto.domain;

import lombok.Getter;

import java.util.List;

public class Lotto {

    @Getter
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}

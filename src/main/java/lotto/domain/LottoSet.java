package lotto.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.Set;

public class LottoSet {

    @Getter
    private final Set<Lotto> lottoSet;

    public LottoSet(Set<Lotto> lottoSet) {
        this.lottoSet = Collections.unmodifiableSet(lottoSet);
    }
}

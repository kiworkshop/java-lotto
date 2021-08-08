package lotto.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class LottoSet {

    @Getter
    private final Set<Lotto> lottoSet;

    public LottoSet(Set<Lotto> lottoSet) {
        this.lottoSet = lottoSet;
    }

    public static LottoSet generateRandomLottoSetWithSize(int size) {
        Set<Lotto> randomLottos = new HashSet<>();
        for (int i = 0; i < size; i++) {
            randomLottos.add(new RandomLotto());
        }
        return new LottoSet(randomLottos);
    }
}

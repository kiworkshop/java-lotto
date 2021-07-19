package lotto.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoSet {

    @Getter
    private final Set<Lotto> lottoSet;

    public LottoSet(Set<Lotto> lottoSet) {
        this.lottoSet = Collections.unmodifiableSet(lottoSet);
    }

    public LottoSet(PurchaseCount purchaseCount) {
        this(generateRandomLottoSetWithSize(purchaseCount));
    }

    private static Set<Lotto> generateRandomLottoSetWithSize(PurchaseCount purchaseCount) {
        Set<Lotto> lottoSet = new HashSet<>();
        for (int i = 0; i < purchaseCount.getPurchaseCount(); i++) {
            lottoSet.add(new RandomLotto());
        }
        return lottoSet;
    }
}

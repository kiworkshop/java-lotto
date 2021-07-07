package lotto.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class RandomLottoSet extends LottoSet {

    public RandomLottoSet(PurchaseCount purchaseCount) {
        super(generateRandomLottoSetWithSize(purchaseCount.getPurchaseCount()));

    }

    private static Set<Lotto> generateRandomLottoSetWithSize(int size) {
        Set<Lotto> lottoSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            lottoSet.add(new RandomLotto());
        }
        return lottoSet;
    }
}

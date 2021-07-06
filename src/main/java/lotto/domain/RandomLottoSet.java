package lotto.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class RandomLottoSet {

    @Getter
    private final Set<RandomLotto> lottoSet = new HashSet<>();

    public RandomLottoSet(PurchaseCount purchaseCount) {
        generateRandomLottoSetWithSize(purchaseCount.getPurchaseCount());
    }

    private void generateRandomLottoSetWithSize(int size) {
        for (int i = 0; i < size; i++) {
            lottoSet.add(new RandomLotto());
        }
    }
}

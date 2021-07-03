package lotto;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class LottoSet {

    @Getter
    private final Set<Lotto> lottoSet = new HashSet<>();

    public LottoSet(PurchaseCount purchaseCount) {
        generateRandomLottoSetWithSize(purchaseCount.getPurchaseCount());
    }

    private void generateRandomLottoSetWithSize(int size) {
        for (int i = 0; i < size; i++) {
            lottoSet.add(new Lotto());
        }
    }
}

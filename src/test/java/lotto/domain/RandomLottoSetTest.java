package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoSetTest {
    private static final int PURCHASE_COUNT_STANDARD = 1000;

    @Test
    void testGenerateLottoSet() throws Exception {
        // given
        int targetSize = 10;
        PurchaseCount purchaseCount = new PurchaseCount(String.valueOf(targetSize * PURCHASE_COUNT_STANDARD));

        // when
        RandomLottoSet randomLottoSet = new RandomLottoSet(purchaseCount);

        // then
        assertThat(randomLottoSet.getLottoSet().size()).isEqualTo(targetSize);
    }
}

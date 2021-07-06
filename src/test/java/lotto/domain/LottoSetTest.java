package lotto.domain;

import lotto.domain.LottoSet;
import lotto.domain.PurchaseCount;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSetTest {

    private static final int PURCHASE_COUNT_STANDARD = 1000;

    @Test
    public void testGenerateLottoSet() throws Exception {
        // given
        int targetSize = 10;
        PurchaseCount purchaseCount = new PurchaseCount(String.valueOf(targetSize * PURCHASE_COUNT_STANDARD));

        // when
        LottoSet lottoSet = new LottoSet(purchaseCount);

        // then
        assertThat(lottoSet.getLottoSet().size()).isEqualTo(targetSize);
    }
}

package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoSetTest {

    @Test
    @DisplayName("개수를 입력받으면 개수만큼 랜덤 로또를 생성한다")
    void testGenerateRandomLottoSet() {
        // given
        int targetSize = 10;
        PurchaseCount purchaseCount = new PurchaseCount(targetSize * Lotto.PRICE);

        // when
        LottoSet lottoSet = new LottoSet(purchaseCount);

        // then
        assertThat(lottoSet.getLottoSet().size()).isEqualTo(targetSize);
    }
}

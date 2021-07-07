package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoSetTest {

    @Test
    @DisplayName("개수를 입력받으면 개수만큼 랜덤 로또를 생성한다")
    void testGenerateLottoSet() throws Exception {
        // given
        int targetSize = 10;
        PurchaseCount purchaseCount = new PurchaseCount(String.valueOf(targetSize * Lotto.PRICE));

        // when
        RandomLottoSet randomLottoSet = new RandomLottoSet(purchaseCount);

        // then
        assertThat(randomLottoSet.getLottoSet().size()).isEqualTo(targetSize);
    }
}

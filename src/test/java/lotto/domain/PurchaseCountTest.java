package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseCountTest {

    @Test
    @DisplayName("구매금액 입력값이 1000 미만이면 예외를 던진다")
    void testInputValueUnder1000() {
        // given
        int input = 800;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseCount(input);
        });
    }

    @Test
    @DisplayName("구매금액 입력값이 1000 이상이면 정상처리된다")
    void testInputValueNotUnder1000() {
        // given
        int input = 2000;

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(input / Lotto.PRICE);
    }

    @Test
    @DisplayName("구매금액 입력값이 1000의 배수가 아니면 예외를 던진다")
    void testInputValueNotMultiple1000() {
        // given
        int input = 1234;

        // when, then
        assertThrows(IllegalArgumentException.class, () ->{
           new PurchaseCount(input);
        });
    }
}

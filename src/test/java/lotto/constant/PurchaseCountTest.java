package lotto.constant;

import lotto.domain.PurchaseCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseCountTest {

    @Test
    @DisplayName("구매금액 입력값이 1000 미만이면 예외를 던진다")
    void testInputValueUnder1000() throws Exception {
        // given
        String input = "800";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new PurchaseCount(input);;
        });
    }

    @Test
    @DisplayName("구매금액 입력값이 1000 이상이면 정상처리된다")
    void testInputValueNotUnder1000() throws Exception {
        // given
        String input = "2000";

        // when, // then
        assertDoesNotThrow(() -> new PurchaseCount(input));
    }

    @Test
    @DisplayName("구매금액 입력값이 1000의 배수가 아니면 예외를 던진다")
    void testInputValueNotMultiple1000() throws Exception {
        // given
        String input = "1234";

        // when, then
        assertThatThrownBy(() -> new PurchaseCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매금액 입력값이 숫자가 아니면 예외를 던진다")
    void testInputNotNumber() throws Exception {
        // given
        String input = "error";

        // when

        // then
        assertThatThrownBy(() -> new PurchaseCount(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("공백이 왼쪽에 있을 때 정상 처리된다")
    void testPriceInputWithLeftBlank() throws Exception {
        // given
        String input = " 1000";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("공백이 오른쪽에 있을 때 정상 처리된다")
    void testPriceInputWithRightBlank() throws Exception {
        // given
        String input = "1000   ";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("공백이 양쪽에 있을 때 정상 처리된다")
    void testPriceInputWithLeftAndRightBlank() throws Exception {
        // given
        String input = "   1000    ";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

}

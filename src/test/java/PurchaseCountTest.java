import lotto.PurchaseCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseCountTest {

    @Test
    @DisplayName("")
    public void testInputValueUnder1000() throws Exception {
        // given
        String input = "800";


        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            PurchaseCount purchaseCount = new PurchaseCount(input);;
        });
    }

    @Test
    @DisplayName("")
    public void testInputValueNotUnder1000() throws Exception {
        // given
        String input = "2000";

        // when, // then
        assertDoesNotThrow(() -> new PurchaseCount(input));
    }

    @Test
    @DisplayName("")
    public void testInputValueNotMultiple1000() throws Exception {
        // given
        String input = "1234";

        // when, then
        assertThatThrownBy(() -> new PurchaseCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("")
    public void testInputNotNumber() throws Exception {
        // given
        String input = "error";

        // when

        // then
        assertThatThrownBy(() -> new PurchaseCount(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("공백이 오른쪽에 있을 때 정상 처리된다")
    public void testPriceInputWithLeftBlank() throws Exception {
        // given
        String input = " 1000";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("공백이 오른쪽에 있을 때 정상 처리된다")
    public void testPriceInputWithRightBlank() throws Exception {
        // given
        String input = "1000   ";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("공백이 양쪽에 있을 때 정상 처리된다")
    public void testPriceInputWithLeftAndRightBlank() throws Exception {
        // given
        String input = "   1000    ";

        // when
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // then
        assertThat(purchaseCount.getPurchaseCount()).isEqualTo(1);
    }

}

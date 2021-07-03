import lotto.PurchasePrice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchasePriceTest {
    @Test
    public void testInputValueUnder1000() throws Exception {
        // given
        String input = "800";


        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            PurchasePrice purchasePrice = new PurchasePrice(input);;
        });
    }

    @Test
    public void testInputValueNotUnder1000() throws Exception {
        // given
        String input = "2000";

        // when, // then
        assertDoesNotThrow(() -> new PurchasePrice(input));
    }

    @Test
    public void testInputValueNotMultiple1000() throws Exception {
        // given
        String input = "1234";

        // when, then
        assertThatThrownBy(() -> new PurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testInputNotNumber() throws Exception {
        // given
        String input = "error";

        // when

        // then
        assertThatThrownBy(() -> new PurchasePrice(input))
                .isInstanceOf(RuntimeException.class);
    }

    // 왼쪽공백, 오른쪽공백, 양옆공백

    @Test
    public void testPriceInputWithLeftBlank() throws Exception {
        // given
        String input = " 1000";

        // when

        // then
        assertDoesNotThrow(() -> new PurchasePrice(input));
    }
}

import lotto.LottoController;
import lotto.LottoService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoControllerTest {
    LottoController lottoController = new LottoController();

    @Test
    public void testInputValueUnder1000() throws Exception {
        // given
        String input = "800";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoController.validate(input);
        });
    }

    @Test
    public void testInputValueNotUnder1000() throws Exception {
        // given
        String input = "2000";

        // when, // then
        assertDoesNotThrow(() -> lottoController.validate(input));
    }

    @Test
    public void testInputValueNotMultiple1000() throws Exception {
        // given
        String input = "1234";

        // when, then
        assertThatThrownBy(() -> lottoController.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testInputNotNumber() throws Exception {
        // given
        String input = "error";

        // when

        // then
        assertThatThrownBy(() -> lottoController.validate(input))
                .isInstanceOf(RuntimeException.class);
    }
}

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    public void testInputValueUnder1000() throws Exception {
        // given
        String input = "800";

        // when, then
        assertThrows(RuntimeException.class, () -> {
            lottoService.validate(input);
        });
    }

    @Test
    public void testInputValueNotUnder1000() throws Exception {
        // given
        String input = "2000";

        // when, // then
        assertDoesNotThrow(() -> lottoService.validate(input));
    }

    @Test
    public void testInputValueNotMultiple1000() throws Exception {
        // given
        String input = "1234";

        // when, then
        assertThatThrownBy(() -> lottoService.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testInputNotNumber() throws Exception {
        // given
        String input = "error";

        // when

        // then
        assertThatThrownBy(() -> lottoService.validate(input))
                .isInstanceOf(RuntimeException.class);
    }
}

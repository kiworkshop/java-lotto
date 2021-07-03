import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoServiceTest {
    LottoService lottoservice;

    @Test
    public void testInputValudUnder1000() throws Exception {
        // given
        int input = 800;

        // when

        // then
        assertThrows(RuntimeException.class, () -> {
            lottoservice.validate(input);
        });
    }
}

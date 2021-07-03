import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    Lotto lotto = new Lotto();

    @Test
    @DisplayName("로또 1개 생성")
    public void testGenerateLotto() throws Exception {
        // given

        // when

        // then
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }
}

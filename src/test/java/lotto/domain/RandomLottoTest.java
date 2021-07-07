package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoTest {

    @Test
    @DisplayName("로또 1개 생성")
    void testGenerateLotto() throws Exception {
        // given
        RandomLotto randomLotto = new RandomLotto();

        // when
        int size = randomLotto.getLottoNumbers().size();

        // then
        assertThat(size).isEqualTo(6);
    }
}

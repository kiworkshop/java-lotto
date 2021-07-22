package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoTest {

    @Test
    @DisplayName("숫자가 6개인 로또를 생성한다")
    void testGenerateLotto() throws Exception {
        // given, when, then
        assertThat(Lotto.generateRandomLotto().lottoNumbers.size()).isEqualTo(Lotto.LOTTO_NUMBER_SIZE);
    }
}

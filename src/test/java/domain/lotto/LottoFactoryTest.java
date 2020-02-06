package domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void LottoFactoryTest() {
        Lotto lotto = LottoFactory.publishLotto();
        assertThat(lotto.getLottoNumbers())
                .size()
                .isEqualTo(6);
    }
}
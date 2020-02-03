package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 46;
    private static final int THRESHOLD_UNDER_LOTTO_NUMBER_RANGE = 0;
    private static final int THRESHOLD_OVER_LOTTO_NUMBER_RANGE = 47;

    @Test
    void testLottoNumber() {
        LottoNumber minimumLottoNumber = LottoNumber.from(MINIMUM_LOTTO_NUMBER);
        LottoNumber maximumLottoNumber = LottoNumber.from(MAXIMUM_LOTTO_NUMBER);

        assertThatThrownBy(() -> LottoNumber.from(THRESHOLD_UNDER_LOTTO_NUMBER_RANGE))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumber.from(THRESHOLD_OVER_LOTTO_NUMBER_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

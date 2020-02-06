package domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 46;
    private static final int NUMBER_UNDER_LOTTO_NUMBER_RANGE = 0;
    private static final int NUMBER_OVER_LOTTO_NUMBER_RANGE = 47;

    private LottoNumber minimumLottoNumber;
    private LottoNumber maximumLottoNumber;

    @BeforeEach
    void setUp() {
        minimumLottoNumber = LottoNumber.from(MINIMUM_LOTTO_NUMBER);
        maximumLottoNumber = LottoNumber.from(MAXIMUM_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("로또 번호 최소 값 미만의 로또 번호 생성시 예외 발생")
    void testMinimumLottoNumberThreshold() {
        assertThatThrownBy(() -> LottoNumber.from(NUMBER_UNDER_LOTTO_NUMBER_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 최대 값 초과의 로또 번호 생성시 예외 발생")
    void testMaximumLottoNumberThreshold() {
        assertThatThrownBy(() -> LottoNumber.from(NUMBER_OVER_LOTTO_NUMBER_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 추출")
    void testLottoNumber() {
        assertThat(minimumLottoNumber.getLottoNumber()).isEqualTo(MINIMUM_LOTTO_NUMBER);
        assertThat(maximumLottoNumber.getLottoNumber()).isEqualTo(MAXIMUM_LOTTO_NUMBER);
    }

    public static Set<LottoNumber> getLottoNumberSetFixture() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        lottoNumberSet.add(LottoNumber.from(1));
        lottoNumberSet.add(LottoNumber.from(2));
        lottoNumberSet.add(LottoNumber.from(3));
        lottoNumberSet.add(LottoNumber.from(4));
        lottoNumberSet.add(LottoNumber.from(5));
        lottoNumberSet.add(LottoNumber.from(6));
        return lottoNumberSet;
    }

    public static Set<LottoNumber> getDuplicateLottoNumberSetFixture() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        lottoNumberSet.add(LottoNumber.from(1));
        lottoNumberSet.add(LottoNumber.from(1));
        lottoNumberSet.add(LottoNumber.from(3));
        lottoNumberSet.add(LottoNumber.from(4));
        lottoNumberSet.add(LottoNumber.from(5));
        lottoNumberSet.add(LottoNumber.from(6));
        return lottoNumberSet;
    }

    public static LottoNumber getSevenLottoNumberFixture() {
        return LottoNumber.from(7);
    }
}

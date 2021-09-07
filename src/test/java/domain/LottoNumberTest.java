package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 42, 43, 45})
    @DisplayName("int 를 인자로 받아 LottoNumber 객체를 반환한다.")
    void of(int number) {
        assertThat(LottoNumber.of(number))
                .isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, -45})
    @DisplayName("인자로 받은 int 가 기준 범위에서 벗어나면 예외가 발생한다.")
    void validateBound(int outOfBoundNumber) {
        assertThatThrownBy(() -> LottoNumber.of(outOfBoundNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호는 %d - %d 사이값을 입력해주세요.", 1, 45);
    }
}
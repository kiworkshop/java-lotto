package domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMoneyTest {

    @Test
    @DisplayName("LottoMoney 객체를 생성")
    void testMoney() {
        LottoMoney lottoMoney = LottoMoney.from(10000);
        assertThat(lottoMoney.getCountOfLotto()).isEqualTo(10);
    }

    @Test
    @DisplayName("Money객체 생성시 음수를 입력하면 예외 발생")
    void testMoneyConstructorUnderZero() {
        assertThatThrownBy(() -> LottoMoney.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money객체 생성시 1000의 배수로 입력하지 않으면 예외 발생")
    void testMoneyConstructor() {
        assertThatThrownBy(() -> LottoMoney.from(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

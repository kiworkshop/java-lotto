package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자는 1과 45 사이의 숫자이다.")
    void create() {
        //given
        int number1 = 0;
        int number2 = 46;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(number1));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(number2));

    }

}
package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @Test
    @DisplayName("주어진 1~45 숫자로 LottoNumber 객체 생성")
    void testGenerateLottoNumberWithInteger() {
        // given
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add("1");
        inputNumbers.add("2");
        inputNumbers.add("44");
        inputNumbers.add("45");
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        // when
        for (String inputNumber : inputNumbers) {
            lottoNumbers.add(new LottoNumber(inputNumber));
        }

        // then
        for (int i = 0; i <lottoNumbers.size() ; i++) {
            assertThat(lottoNumbers.get(i).getLottoNumber()).isEqualTo(Integer.parseInt(inputNumbers.get(i)));
        }
    }

    @Test
    @DisplayName("1보다 작은 숫자로 LottoNumber 생성 시 예외")
    void testGenerateLottoNumberWithIntegerLessThanLowerBound() {
        //given
        String inputNumber = "0";

        //when, then
        assertThrows(IllegalArgumentException.class, ()-> {
           new LottoNumber(inputNumber);
        });
    }

    @Test
    @DisplayName("45보다 큰 숫자로 LottoNumber 생성 시 예외")
    void testGenerateLottoNumberWithIntegerGreaterThanUpperBound() {
        //given
        String inputNumber = "46";

        //when, then
        assertThrows(IllegalArgumentException.class, ()-> {
            new LottoNumber(inputNumber);
        });
    }
}

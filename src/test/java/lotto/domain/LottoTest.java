package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void testEqualityOfLottos() {
        // given
        List<LottoNumber> lottoNumbersOne = new ArrayList<>();
        lottoNumbersOne.add(new LottoNumber("1"));
        lottoNumbersOne.add(new LottoNumber("30"));
        lottoNumbersOne.add(new LottoNumber("22"));

        List<LottoNumber> lottoNumbersTwo = new ArrayList<>();
        lottoNumbersTwo.add(new LottoNumber("22"));
        lottoNumbersTwo.add(new LottoNumber("30"));
        lottoNumbersTwo.add(new LottoNumber("1"));

        // when
        Lotto one = new Lotto(lottoNumbersOne);
        Lotto two = new Lotto(lottoNumbersTwo);

        // then
        assertThat(one).isEqualTo(two);
    }
}

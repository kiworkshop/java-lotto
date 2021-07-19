package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void testEqualityOfLottos() {
        // given
        List<Integer> lottoNumbersOne = new ArrayList<>();
        lottoNumbersOne.add(1);
        lottoNumbersOne.add(30);
        lottoNumbersOne.add(22);
        lottoNumbersOne.add(5);
        lottoNumbersOne.add(42);
        lottoNumbersOne.add(17);

        List<Integer> lottoNumbersTwo = new ArrayList<>();
        lottoNumbersTwo.add(17);
        lottoNumbersTwo.add(22);
        lottoNumbersTwo.add(5);
        lottoNumbersTwo.add(30);
        lottoNumbersTwo.add(1);
        lottoNumbersTwo.add(42);

        // when
        Lotto one = new Lotto(lottoNumbersOne);
        Lotto two = new Lotto(lottoNumbersTwo);

        // then
        assertThat(one).isEqualTo(two);
    }
}

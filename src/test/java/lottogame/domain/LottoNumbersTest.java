package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    private static final int COUNT_OF_LOTTO_NUMBERS = 6;

    private List<Integer> expected = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 45; i++) {
            expected.add(i);
        }
    }

    @Test
    void selectLottoNumbers후에도_리스트는_그대로여야_한다() {
        // given 
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        lottoNumbers.selectLottoNumbersBy(COUNT_OF_LOTTO_NUMBERS);

        // then 
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expected);
    }
}
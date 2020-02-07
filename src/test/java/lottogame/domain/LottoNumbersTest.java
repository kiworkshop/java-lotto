package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> expected = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 45; i++) {
            expected.add(i);
        }
    }

    @Test
    void LottoNumbers는_모든_로또숫자를_가지고_있다() {
        // given 
        LottoNumbers lottoNumbers = new LottoNumbers();

        // then 
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expected);
    }

    @Test
    void selectLottoNumbers후에도_리스트는_그대로여야_한다() {
        // given 
        LottoNumbers lottoNumbers = new LottoNumbers();

        // when
        lottoNumbers.selectLottoNumbersBy(LOTTO_NUMBER_COUNT);

        // then 
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expected);
    }
}
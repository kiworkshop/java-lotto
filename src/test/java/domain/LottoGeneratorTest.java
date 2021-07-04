package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private static final int LOTTO_SIZE = 6;

    @Test
    @DisplayName("1부터 45이하의 중복되지 않는 로또 번호 중 7개를 리턴한다")
    void generateLottoTest() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();

        //when
        Lotto lotto = lottoGenerator.generateLotto();

        //then
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(LOTTO_SIZE);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(lotto.getLottoNumbers().stream()
                .distinct()
                .count());

    }
}
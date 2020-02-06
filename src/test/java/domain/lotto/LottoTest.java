package domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static domain.lotto.LottoNumberTest.getDuplicateLottoNumberSetFixture;
import static domain.lotto.LottoNumberTest.getLottoNumberSetFixture;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void testLotto() {
        Set<LottoNumber> lottoNumberSet = getLottoNumberSetFixture();

        Lotto lotto = Lotto.from(lottoNumberSet);
        assertThat(lotto);
    }

    @Test
    void generateLottoWithWrongLottoNumber() {
        Set<LottoNumber> lottoNumbers = getDuplicateLottoNumberSetFixture();

        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

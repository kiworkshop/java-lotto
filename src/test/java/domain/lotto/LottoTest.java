package domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static domain.lotto.LottoNumberTest.getDuplicateLottoNumberSetFixture;
import static domain.lotto.LottoNumberTest.getLottoNumberSetFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void testLotto() {
        Set<LottoNumber> lottoNumbers = getLottoNumberSetFixture();

        Lotto lotto = Lotto.from(lottoNumbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void generateLottoWithWrongLottoNumber() {
        Set<LottoNumber> lottoNumbers = getDuplicateLottoNumberSetFixture();

        assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Lotto getLottoFromOneToSixFixture() {
        Set<LottoNumber> lottoNumbers = getLottoNumberSetFixture();
        return Lotto.from(lottoNumbers);
    }
}

package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static domain.lotto.LottoNumberTest.getDuplicateLottoNumberSetFixture;
import static domain.lotto.LottoNumberTest.getLottoNumberSetFixture;
import static domain.lotto.LottoNumberTest.getSevenLottoNumberFixture;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto를 생성하는 메서드 생성")
    void testWinningLotto() {
        Set<LottoNumber> lottoNumbers = getLottoNumberSetFixture();
        LottoNumber sevenLottoNumber = getSevenLottoNumberFixture();
        WinningLotto.from(lottoNumbers, sevenLottoNumber);
    }

    @Test
    @DisplayName("WinningLotto를 생성하는 상황에서 예외 발생 당첨 번호는 6개여야 한다.")
    void duplicateLottoNumberThrowsException() {
        Set<LottoNumber> duplicateLottoNumbers = getDuplicateLottoNumberSetFixture();
        LottoNumber sevenLottoNumber = getSevenLottoNumberFixture();

        assertThatThrownBy(() -> WinningLotto.from(duplicateLottoNumbers, sevenLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningLotto를 생성하는 상황에서 예외 발생. 보너스 번호는 당첨 번호에 없는 번호여야 한다.")
    void lottoNumberHasBonusNumberThrowsException() {
        Set<LottoNumber> lottoNumbers = getLottoNumberSetFixture();

        assertThatThrownBy(() -> WinningLotto.from(lottoNumbers, lottoNumbers.iterator().next()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
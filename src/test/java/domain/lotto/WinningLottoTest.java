package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.lotto.LottoNumberTest.getOneLottoNumberFixture;
import static domain.lotto.LottoNumberTest.getSevenLottoNumberFixture;
import static domain.lotto.LottoTest.getLottoFromOneToSixFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    @DisplayName("WinningLotto를 생성하는 메서드 생성")
    void testWinningLotto() {
        Lotto winningLotto = getLottoFromOneToSixFixture();
        LottoNumber sevenLottoNumber = getSevenLottoNumberFixture();
        WinningLotto.from(winningLotto, sevenLottoNumber);
    }

    @Test
    @DisplayName("WinningLotto를 생성하는 상황에서 예외 발생. 보너스 번호는 당첨 번호에 없는 번호여야 한다.")
    void lottoNumberHasBonusNumberThrowsException() {
        Lotto winningLotto = getLottoFromOneToSixFixture();
        LottoNumber oneLottoNumber = getOneLottoNumberFixture();

        assertThatThrownBy(() -> WinningLotto.from(winningLotto, oneLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testWinningLottoMatches() {
        WinningLotto winningLotto = getWinningLottoFromOneToSixWithSevenFixture();
        Lotto lotto = getLottoFromOneToSixFixture();

        assertThat(winningLotto.match(lotto)).isEqualTo(6);
    }

    public static WinningLotto getWinningLottoFromOneToSixWithSevenFixture() {
        Lotto winningLotto = getLottoFromOneToSixFixture();
        LottoNumber sevenLottoNumber = getSevenLottoNumberFixture();
        return WinningLotto.from(winningLotto, sevenLottoNumber);
    }
}
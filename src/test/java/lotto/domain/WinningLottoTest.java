package lotto.domain;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    @Test
    @DisplayName("WinningNumbers 타입 확인")
    public void test() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 6";
        String bonus = "10";
        WinningLotto winningLotto = new WinningLotto(input, bonus);

        // when

        // then
        assertThat(winningLotto.getLottoNumbers()).isExactlyInstanceOf(ArrayList.class);
    }

    @Test
    @DisplayName("숫자가 6개인지 확인")
    public void testWinningNumberSize() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 6";
        String bonus = "10";

        // when
        WinningLotto winningLotto = new WinningLotto(input, bonus);

        // then
        assertThat(winningLotto.getLottoNumbers().size()).isEqualTo(6);

    }


    @Test
    @DisplayName("숫자가 아닌 값 포함")
    public void testInputWithNonInteger() throws Exception {
        // given
        String input = "1, a, 3, 4, 5, 6";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("로또 번호 입력값이 45 초과면 예외 발생")
    public void testInputGreaterThanUpperBoundary() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 46";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("로또 번호 입력값이 1 미만이면 예외 발생")
    public void testInputSmallerThanLowerBoundary() throws Exception {
        // given
        String input = "0, 2, 3, 4, 5, 6";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값을 확인")
    void testBonusInput() {
        //given
        String input = "1, 2, 3, 4, 5, 6";
        String bonus = "10";

        // when
        WinningLotto winningLotto = new WinningLotto(input, bonus);

        // then
        assertThat(winningLotto.getBonusNumber().getLottoNumber()).isEqualTo(10);
    }

}

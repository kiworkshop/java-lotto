package lotto.domain;

import lotto.constant.Prize;
import lotto.parser.LottoParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    private final String winningNumberInput = "1, 2, 3, 4, 5, 6";
    private final String bonusNumberInput = "10";
    private static Lotto targetLotto;
    private final WinningLotto winningLotto = new WinningLotto(winningNumberInput, bonusNumberInput);

    @BeforeAll
    private static void generateTargetLotto() {
        targetLotto = new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    @DisplayName("숫자가 6개인지 확인한다")
    void testWinningNumberSize() throws Exception {
        // given, when, then
        assertThat(winningLotto.getLotto().getLottoNumbers().size()).isEqualTo(Lotto.LOTTO_NUMBER_SIZE);
    }

    @Test
    @DisplayName("숫자가 아닌 값 포함할 때 예외를 던진다")
    void testInputWithNonInteger() throws Exception {
        // given
        String input = "1, a, 3, 4, 5, 6";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("45 초과인 값 포함할 때 예외를 던진다")
    void testInputGreaterThanUpperBoundary() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 46";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("1 미만인 값 포함할 때 예외를 던진다")
    void testInputSmallerThanLowerBoundary() throws Exception {
        // given
        String input = "0, 2, 3, 4, 5, 6";
        String bonus = "10";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(input, bonus);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력값을 확인한다")
    void testBonusInput() {
        //given, when, then
        assertThat(winningLotto.getBonusNumber().getLottoNumber())
                .isEqualTo(Integer.parseInt(bonusNumberInput));
    }

    @Test
    @DisplayName("숫자가 6개 일치할 때 1등")
    void testFindPrize_firstWithoutBonus() {
        //given, when
        Prize prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스번호도 일치할 때 2등")
    void testFindPrize_secondWithBonus() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", "6");
        Prize prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스 번호가 일치하지 않을 때 3등")
    void testFindPrize_third() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", bonusNumberInput);
        Prize prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("숫자가 4개 일치할 때 4등")
    void testFindPrize_fourth() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("4,3,2,1,8,7", bonusNumberInput);
        Prize prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("숫자가 3개 일치할 때 5등")
    void testFindPrize_fifth() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("4,3,2,9,8,7", bonusNumberInput);
        Prize prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }
}

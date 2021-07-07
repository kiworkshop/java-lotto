package lotto.domain;

import lotto.constant.PrizeCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {

    private final String winningNumberInput = "1, 2, 3, 4, 5, 6";
    private final String bonusNumberInput = "10";
    private static Lotto targetLotto;
    private final WinningLotto winningLotto = new WinningLotto(winningNumberInput, bonusNumberInput);

    @BeforeAll
    private static void generateTargetLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber("1"));
        lottoNumbers.add(new LottoNumber("2"));
        lottoNumbers.add(new LottoNumber("3"));
        lottoNumbers.add(new LottoNumber("4"));
        lottoNumbers.add(new LottoNumber("5"));
        lottoNumbers.add(new LottoNumber("6"));
        targetLotto = new Lotto(lottoNumbers);
    }

    @Test
    @DisplayName("WinningNumbers 타입 확인")
    public void test() throws Exception {
        // given, when, then
        assertThat(winningLotto.getLottoNumbers()).isExactlyInstanceOf(ArrayList.class);
    }

    @Test
    @DisplayName("숫자가 6개인지 확인")
    public void testWinningNumberSize() throws Exception {
        // given, when, then
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
        //given, when, then
        assertThat(winningLotto.getBonusNumber().getLottoNumber()).isEqualTo(10);
    }

    @Test
    @DisplayName("보너스 미포함 6개 맞으면 1등")
    void testFindPrize_firstWithoutBonus() {
        //given, when
        PrizeCondition prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(PrizeCondition.FIRST);
    }

    @Test
    @DisplayName("5개 + 보너스 맞으면 2등")
    void testFindPrize_secondWithBonus() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", "6");
        PrizeCondition prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(PrizeCondition.SECOND);
    }

    @Test
    @DisplayName("5개 + 보너스 안 맞으면 3등")
    void testFindPrize_third() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,7", bonusNumberInput);
        PrizeCondition prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(PrizeCondition.THIRD);
    }

    @Test
    @DisplayName("보너스 미포함 4개 맞으면 4등")
    void testFindPrize_fourth() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("4,3,2,1,8,7", bonusNumberInput);
        PrizeCondition prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(PrizeCondition.FOURTH);
    }

    @Test
    @DisplayName("보너스 미포함 3개 맞으면 5등")
    void testFindPrize_fifth() {
        //given, when
        WinningLotto winningLotto = new WinningLotto("4,3,2,9,8,7", bonusNumberInput);
        PrizeCondition prize = winningLotto.findPrize(targetLotto);

        //then
        assertThat(prize).isEqualTo(PrizeCondition.FIFTH);
    }
}

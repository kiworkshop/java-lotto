package lotto.domain;

import lotto.domain.dto.WinningLottoInputDTO;
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
    private final WinningLotto winningLotto = new WinningLotto(
            new WinningLottoInputDTO(winningNumberInput, bonusNumberInput)
    );

    @BeforeAll
    private static void generateTargetLotto() {
        targetLotto = new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 6"));
    }

    @Test
    @DisplayName("숫자가 6개인지 확인한다")
    void testWinningNumberSize() throws Exception {
        // given, when, then
        assertThat(winningLotto.getLottoNumbers().size()).isEqualTo(Lotto.LOTTO_NUMBER_SIZE);
    }

    @Test
    @DisplayName("숫자가 아닌 값 포함할 때 예외를 던진다")
    void testInputWithNonInteger() throws Exception {
        // given
        String input = "1, a, 3, 4, 5, 6";
        String bonus = "10";
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers(input)
                .winningLottoBonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInputDTO);
        });
    }

    @Test
    @DisplayName("45 초과인 값 포함할 때 예외를 던진다")
    void testInputGreaterThanUpperBoundary() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 46";
        String bonus = "10";
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers(input)
                .winningLottoBonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInputDTO);
        });
    }

    @Test
    @DisplayName("1 미만인 값 포함할 때 예외를 던진다")
    void testInputSmallerThanLowerBoundary() throws Exception {
        // given
        String input = "0, 2, 3, 4, 5, 6";
        String bonus = "10";
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers(input)
                .winningLottoBonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInputDTO);
        });
    }

    @Test
    @DisplayName("6개 이하의 숫자가 입력됐을 때 예외를 던진다")
    void testInputLengthLessThanStandard() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5";
        String bonus = "10";
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers(input)
                .winningLottoBonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInputDTO);
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
        Prize prize = winningLotto.findPrizeCondition(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FIRST);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스번호도 일치할 때 2등")
    void testFindPrize_secondWithBonus() {
        //given
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers("1,2,3,4,5,7")
                .winningLottoBonus("6")
                .build();

        // when
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        Prize prize = winningLotto.findPrizeCondition(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }

    @Test
    @DisplayName("숫자가 5개 일치하고 보너스 번호가 일치하지 않을 때 3등")
    void testFindPrize_third() {
        //given
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers("1,2,3,4,5,7")
                .winningLottoBonus(bonusNumberInput)
                .build();

        // when
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        Prize prize = winningLotto.findPrizeCondition(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.THIRD);
    }

    @Test
    @DisplayName("숫자가 4개 일치할 때 4등")
    void testFindPrize_fourth() {
        //given
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers("4,3,2,1,8,7")
                .winningLottoBonus(bonusNumberInput)
                .build();

        // when
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        Prize prize = winningLotto.findPrizeCondition(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FOURTH);
    }

    @Test
    @DisplayName("숫자가 3개 일치할 때 5등")
    void testFindPrize_fifth() {
        //given
        WinningLottoInputDTO winningLottoInputDTO = WinningLottoInputDTO.builder()
                .winningLottoNumbers("4,3,2,9,8,7")
                .winningLottoBonus(bonusNumberInput)
                .build();

        // when
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        Prize prize = winningLotto.findPrizeCondition(targetLotto);

        //then
        assertThat(prize).isEqualTo(Prize.FIFTH);
    }
}

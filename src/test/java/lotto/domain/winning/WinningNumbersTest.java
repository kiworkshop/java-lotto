package lotto.domain.winning;

import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @Test
    @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다")
    void validate_duplication_winning_number() {
        //given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        int bonusNumber = 6;

        //when //then
        assertThatThrownBy(() -> new WinningNumbers(inputNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되는 경우 예외가 발생한다")
    void validate_duplication_bonus_number() {
        //given
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        //when //then
        assertThatThrownBy(() -> new WinningNumbers(inputNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("hitLottoNumbers")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다")
    void hit_winning_numbers_count(LottoTicket lottoTicket, int expectedCount) {
        //given
        WinningNumbers winningNumbers = generateWinningNumber(45);

        //when
        int hitCount = winningNumbers.hitCount(lottoTicket);

        //then
        assertThat(hitCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("보너스 번호 일치하는 로또 번호 개수를 반환한다")
    void hit_bonus_number_count() {
        //given
        LottoTicket lottoTicket = new LottoTicket(5, 10, 15, 20, 25, 30);
        WinningNumbers winningNumbers = generateWinningNumber(30);

        //when
        boolean isBonus = winningNumbers.hitBonus(lottoTicket);

        //then
        assertThat(isBonus).isTrue();
    }

    private WinningNumbers generateWinningNumber(int bonusNumber) {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    private static Stream<Arguments> hitLottoNumbers() {
        return Stream.of(
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(new LottoTicket(2, 3, 4, 5, 6, 7), 5),
                Arguments.of(new LottoTicket(3, 4, 5, 6, 7, 8), 4),
                Arguments.of(new LottoTicket(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(new LottoTicket(5, 6, 7, 8, 9, 10), 2),
                Arguments.of(new LottoTicket(6, 7, 8, 9, 10, 11), 1),
                Arguments.of(new LottoTicket(7, 8, 9, 10, 11, 12), 0)
        );
    }
}

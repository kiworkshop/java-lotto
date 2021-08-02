package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}

import lotto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.PATH;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumbersTest {

    @Test
    @DisplayName("WinningNumbers 타입 확인")
    public void test() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 6";
        WinningNumbers winningNumbers = new WinningNumbers(input);

        // when

        // then
        assertThat(winningNumbers.getWinningNumbers()).isExactlyInstanceOf(ArrayList.class);
    }

    @Test
    @DisplayName("숫자가 6개인지 확인")
    public void testWinningNumberSize() throws Exception {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        WinningNumbers winningNumbers = new WinningNumbers(input);

        // then
        assertThat(winningNumbers.getWinningNumbers().size()).isEqualTo(6);

    }


    @Test
    @DisplayName("숫자가 아닌 값 포함")
    public void testInputWithNonInteger() throws Exception {
        // given
        String input = "1, a, 3, 4, 5, 6";

        // when, then
        assertThrows(NumberFormatException.class, () -> {
            new WinningNumbers(input);
        });
    }
}

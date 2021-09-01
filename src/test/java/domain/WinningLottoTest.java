package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨번호와 복권의 숫자가 일치하는 갯수에 따라 적합한 Rank 를 리턴한다.")
    void getRank() {
        //given
        LottoTicket firstWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket secondWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto lastWeekWinningNumbers = new WinningLotto(winningNumbers, bonusNumber);

        //when
        Rank firstPlace = lastWeekWinningNumbers.getRank(firstWinningLottoTicket);
        Rank secondPlace = lastWeekWinningNumbers.getRank(secondWinningLottoTicket);

        //then
        assertThat(firstPlace).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
    }
}

package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("당첨번호와 복권의 숫자가 일치하는 갯수에 따라 적합한 Rank 를 리턴한다.")
    void getRank() {
        //given
        LottoTicket firstWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket secondWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTicket thirdWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8));
        LottoTicket fourthWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        LottoTicket fifthWinningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 8, 9, 10));

        LottoNumber bonusNumber = LottoNumber.of(7);
        WinningLotto lastWeekWinningLotto = new WinningLotto(firstWinningLottoTicket, bonusNumber);

        //when
        Rank firstPlace = lastWeekWinningLotto.getRank(firstWinningLottoTicket).get();
        Rank secondPlace = lastWeekWinningLotto.getRank(secondWinningLottoTicket).get();
        Rank thirdPlace = lastWeekWinningLotto.getRank(thirdWinningLottoTicket).get();
        Rank fourthPlace = lastWeekWinningLotto.getRank(fourthWinningLottoTicket).get();
        Rank fifthPlace = lastWeekWinningLotto.getRank(fifthWinningLottoTicket).get();

        //then
        assertThat(firstPlace).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
        assertThat(thirdPlace).isEqualTo(Rank.THIRD_PLACE);
        assertThat(fourthPlace).isEqualTo(Rank.FOURTH_PLACE);
        assertThat(fifthPlace).isEqualTo(Rank.FIFTH_PLACE);
    }
}

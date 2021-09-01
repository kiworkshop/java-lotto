package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("당첨번호가 모두 일치하면 1등 당첨인 로또 랭크를 리턴한다.")
    void getRank() {
        //given
        List<Integer> firstWinningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondWinningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        WinningLotto firstWinningLotto = new WinningLotto(firstWinningLottoNumbers);
        firstWinningLotto.setRank(winningNumbers, bonusNumber);
        Rank firstPlace = firstWinningLotto.getRank();

        WinningLotto secondWinningLotto = new WinningLotto(secondWinningLottoNumbers);
        secondWinningLotto.setRank(winningNumbers, bonusNumber);
        Rank secondPlace = secondWinningLotto.getRank();

        //then
        assertThat(firstPlace).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
    }
}

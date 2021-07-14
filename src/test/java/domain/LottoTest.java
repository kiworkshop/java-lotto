package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또를_생성하면_로또_로또번호가_부여된다() {
        //given
        LottoMachine lottoMachine = new LottoMachine("1000");
        Lotto lotto = new Lotto(lottoMachine.createRandomNumber());
        //when
        //than
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumbers().stream().distinct().count()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호가 모두 일치하면 1등 당첨인 로또 랭크를 리턴한다.")
    public void getRank() {
        //given
        List<Integer> firstWinningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondWinningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        //when
        Lotto firstWinningLotto = new Lotto(firstWinningLottoNumbers);
        firstWinningLotto.setRank(winningNumbers, bonusNumber);
        Rank firstPlace = firstWinningLotto.getRank();

        Lotto secondWinningLotto = new Lotto(secondWinningLottoNumbers);
        secondWinningLotto.setRank(winningNumbers, bonusNumber);
        Rank secondPlace = secondWinningLotto.getRank();

        //then
        assertThat(firstPlace).isEqualTo(Rank.FIRST_PLACE);
        assertThat(secondPlace).isEqualTo(Rank.SECOND_PLACE);
    }
}

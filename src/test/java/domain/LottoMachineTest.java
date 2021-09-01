package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 돈을_입력받으면_구매한_로또_수를_리턴한다() {
        //given
        int givenMoney = 14000;
        LottoMachine lottoMachine = new LottoMachine(givenMoney);
        //when //than
        assertThat(lottoMachine.getLottoTicketCount()).isEqualTo(14);
    }

    @Test
    void _1부터_45사이의_숫자중_중복되지_않는_6개를_뽑아서_오름차순으로_리턴한다() {
        //given
        LottoMachine lottoMachine = new LottoMachine(1000);
        //when
        List<Integer> lottoNumbers = lottoMachine.createNonDuplicateNumbers();
        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);

    }

    @Test
    void 부여받은_티켓_개수대로_로또_만들어서_리턴한다() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        //when
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets();
        //then
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("1등_당첨_결과를_리턴한다")
    void getRankResult() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<WinningLotto> lottoTicket = new ArrayList<>();

        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        TreeMap<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);

        //then
        assertThat(rankResult.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isEqualTo(0);
        assertThat(rankResult.get(Rank.THIRD_PLACE)).isEqualTo(0);
    }

    @Test
    @DisplayName("2등_당첨_결과를_리턴한다")
    void getRankResult2() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<WinningLotto> lottoTicket = new ArrayList<>();

        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        TreeMap<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);

        //then
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다")
    void getProfitRate() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<WinningLotto> lottoTicket = new ArrayList<>();

        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);
        double profitRate = lottoMachine.getProfitRate(money, rankResult);

        //then
        assertThat(profitRate).isEqualTo(2000000);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다")
    void getProfitRate2() {
        //given
        int money = 5000;
        LottoMachine lottoMachine = new LottoMachine(money);
        List<WinningLotto> lottoTicket = new ArrayList<>();

        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto lotto2 = new WinningLotto(Arrays.asList(6, 7, 8, 9, 10, 11));
        lottoTicket.add(lotto);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);

        //when
        lottoMachine.getRankResult(lottoTicket, Arrays.asList(1, 2, 3, 11, 12, 13), 7);
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottoTicket);
        double profitRate = lottoMachine.getProfitRate(money, rankResult);

        //then
        assertThat(profitRate).isEqualTo(1);
    }

}



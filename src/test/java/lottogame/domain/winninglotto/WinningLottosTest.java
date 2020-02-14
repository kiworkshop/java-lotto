package lottogame.domain.winninglotto;

import lottogame.domain.MoneyAmount;
import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottosTest {

    LottoTicket lottoResult;
    LottoTicket thirdRankLottoTicket1;
    LottoTicket thirdRankLottoTicket2;
    LottoTicket otherRankLottoTicket;
    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        String lottoResultInput = "1,3,5,7,9,11";
        lottoResult = LottoTicket.createWith(lottoResultInput);

        String thirdRankInput1 = "2,4,5,7,9,11";
        String thirdRankInput2 = "1,3,5,7,44,45";
        String otherRankInput = "2,4,6,8,10,12";
        thirdRankLottoTicket1 = LottoTicket.createWith(thirdRankInput1);
        thirdRankLottoTicket2 = LottoTicket.createWith(thirdRankInput2);
        otherRankLottoTicket = LottoTicket.createWith(otherRankInput);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(thirdRankLottoTicket1);
        lottoTicketList.add(thirdRankLottoTicket2);
        lottoTicketList.add(otherRankLottoTicket);
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    @Test
    void 로또개수만큼_winningLottos가_만들어지는가() {
        //given
        WinningLottos winningLottos = WinningLottos.computeWinningStatistics(lottoTickets, lottoResult);

        //then
        assertThat(winningLottos.getWinningLottos().size()).isEqualTo(lottoTickets.getLottoTickets().size());
    }

    @Test
    void winningLottos가_적절한_WinningLotto를_생성해내는가() {
        // given
        List<WinningLotto> winningStatistics = new ArrayList<>();
        winningStatistics.add(WinningLotto.THIRD);
        winningStatistics.add(WinningLotto.THIRD);
        winningStatistics.add(WinningLotto.OTHERS);
        WinningLottos expected = new WinningLottos(winningStatistics);

        WinningLottos winningLottos = WinningLottos.computeWinningStatistics(lottoTickets, lottoResult);

        // then
        assertThat(winningLottos.getWinningLottos()).isEqualTo(expected.getWinningLottos());
    }

    @Test
    void WinningLotto의_개수를_잘계산하는가_() {
        // given
        WinningLottos winningLottos = WinningLottos.computeWinningStatistics(lottoTickets, lottoResult);

        //when
        int countOfThird = winningLottos.countWinningLotto(WinningLotto.THIRD);
        int countOfOthers = winningLottos.countWinningLotto(WinningLotto.OTHERS);
        int countOfFirst = winningLottos.countWinningLotto(WinningLotto.FIRST);

        //then
        assertThat(countOfThird).isEqualTo(2);
        assertThat(countOfOthers).isEqualTo(1);
        assertThat(countOfFirst).isEqualTo(0);
    }

    @Test
    void EarningRate를_잘_계산하고있는가() {
        //given
        double totalPrizeMoney = WinningLotto.THIRD.getPrizeMoney() * 2;
        double countOfLottos = 3;
        double expected = (totalPrizeMoney / (countOfLottos * MoneyAmount.ONE_LOTTO_PRICE)) * 100;

        WinningLottos winningLottos = WinningLottos.computeWinningStatistics(lottoTickets, lottoResult);

        //when
        double earningRate = winningLottos.computeEarningRate();

        //then
        assertThat(earningRate).isEqualTo(expected);
    }
}
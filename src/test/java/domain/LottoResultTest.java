package domain;

import enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("로또 티켓의 당첨 결과를 반환한다.")
    void getLottoResult() {
        //given
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoTicket ticket3 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8));
        LottoTicket ticket4 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        LottoTicket ticket5 = new LottoTicket(Arrays.asList(1, 2, 3, 8, 9, 10));

        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        purchasedLottoTickets.add(ticket1);
        purchasedLottoTickets.add(ticket2);
        purchasedLottoTickets.add(ticket3);
        purchasedLottoTickets.add(ticket4);
        purchasedLottoTickets.add(ticket5);

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoResult lottoResult = new LottoResult();

        //when
        lottoResult.getLottoResult(purchasedLottoTickets, winningLotto);
        Map<Rank, Integer> entry = lottoResult.getLottoResult();

        //then
        assertThat(entry).containsEntry(Rank.FIRST_PLACE, 1);
        assertThat(entry).containsEntry(Rank.SECOND_PLACE, 1);
        assertThat(entry).containsEntry(Rank.THIRD_PLACE, 1);
        assertThat(entry).containsEntry(Rank.FOURTH_PLACE, 1);
        assertThat(entry).containsEntry(Rank.FIFTH_PLACE, 1);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProfitRate() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        LottoTicket firstWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        purchasedLottoTickets.add(firstWinningTicket);
        WinningLotto firstWinningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when
        LottoResult lottoResult = new LottoResult();
        lottoResult.getLottoResult(purchasedLottoTickets, firstWinningLotto);
        double profitRate = lottoResult.getProfitRate(purchaseMoney, lottoResult.getLottoResult());

        //then
        assertThat(profitRate).isEqualTo(2_000_000);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProfitRate2() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(5000);
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);

        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        LottoTicket notWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket fifthWinningTicket = new LottoTicket(Arrays.asList(6, 7, 8, 9, 10, 11));

        purchasedLottoTickets.add(fifthWinningTicket);

        for (int i = 1; i < lottoMachine.getLottoTicketCount(); i++) {
            purchasedLottoTickets.add(notWinningTicket);
        }

        WinningLotto fifthWinningLotto = new WinningLotto(Arrays.asList(9, 10, 11, 12, 13, 14), 15);

        //when
        LottoResult lottoResult = new LottoResult();
        lottoResult.getLottoResult(purchasedLottoTickets, fifthWinningLotto);
        double profitRate = lottoResult.getProfitRate(purchaseMoney, lottoResult.getLottoResult());

        //then
        assertThat(profitRate).isEqualTo(1);
    }
}
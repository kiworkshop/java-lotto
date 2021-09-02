package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @BeforeEach
    void BeforeEach() {
        LottoTicket firstWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket fifthWinningTicket = new LottoTicket(Arrays.asList(6, 7, 8, 9, 10, 11));
        WinningLotto firstWinningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        WinningLotto fifthWinningLotto = new WinningLotto(Arrays.asList(9, 10, 11, 12, 13, 14), 15);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProfitRate() {
        //given
        int money = 1000;
        List<LottoTicket> purchasedLottoTickets = new ArrayList<>();
        LottoTicket firstWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        purchasedLottoTickets.add(firstWinningTicket);
        WinningLotto firstWinningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when
        LottoResult lottoResult = new LottoResult();
        lottoResult.getLottoResult(purchasedLottoTickets, firstWinningLotto);
        double profitRate = lottoResult.getProfitRate(money, lottoResult.getLottoResult());

        //then
        assertThat(profitRate).isEqualTo(2_000_000);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다.")
    void getProfitRate2() {
        //given
        int money = 5000;
        LottoMachine lottoMachine = new LottoMachine(money);

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
        double profitRate = lottoResult.getProfitRate(money, lottoResult.getLottoResult());

        //then
        assertThat(profitRate).isEqualTo(1);
    }
}
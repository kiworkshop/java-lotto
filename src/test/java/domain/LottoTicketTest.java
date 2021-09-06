package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 1장 당 6개의 중복되지 않는 로또번호로 구성된다.")
    void checkLottoTicket() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);
        int manualTicketCount = 0;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, manualTicketCount);

        //when
        List<LottoTicket> lottoTicket = lottoMachine.buyLottoTickets();

        //then
        assertThat(lottoTicket.get(0)
                .getLottoTicketNumbers()
                .size())
                .isEqualTo(6);

        assertThat(lottoTicket.get(0)
                .getLottoTicketNumbers()
                .stream()
                .distinct()
                .count())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("로또 티켓의 번호를 하나의 LottoNumber 씩 리스트에 담아 반환한다.")
    void getLottoTicketNumbers() {
        //given
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 13, 27, 36, 40, 45));

        //when
        List<LottoNumber> ticketNumbers = lottoTicket.getLottoTicketNumbers();

        //then
        for (LottoNumber lottoNumber : ticketNumbers) {
            assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
        }
    }
}
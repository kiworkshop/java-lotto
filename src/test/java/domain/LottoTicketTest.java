package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 1장 당 6개의 중복되지 않는 로또번호로 구성된다.")
    void buyLottoTicket() {
        //given
        LottoMachine lottoMachine = new LottoMachine(1000);

        //when
        List<LottoTicket> lottoTicket = lottoMachine.buyLottoTickets();

        //then
        assertThat(lottoTicket.size()).isEqualTo(6);
        assertThat(lottoTicket.stream().distinct().count()).isEqualTo(6);
    }
}
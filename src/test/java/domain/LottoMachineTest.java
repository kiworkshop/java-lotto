package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("돈을 입력받으면 구매할 수 있는 로또 티켓 개수를 반환한다.")
    void getLottoTicketCount() {
        //given
        int givenMoney = 14000;
        LottoMachine lottoMachine = new LottoMachine(givenMoney);
        //when //than
        assertThat(lottoMachine.getLottoTicketCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("부여받은 티켓 개수만큼 LottoTicket 을 생성한다.")
    void buyLottoTickets() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        //when
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets();
        //then
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

}



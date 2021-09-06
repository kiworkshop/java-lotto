package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("자동, 수동티켓 별로 부여받은 개수만큼 LottoTicket 을 생성한다.")
    void buyLottoTickets() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(1000);
        int manualTicketCount = 0;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, manualTicketCount);
        //when
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets();
        //then
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

}



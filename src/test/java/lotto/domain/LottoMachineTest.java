package lotto.domain;

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
        List<LottoTicket> lottoTickets = lottoMachine.buyAutoTickets();
        //then
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("구매를 원하는 수동 티켓의 수를 입력하면 남은 돈으로 살 수 있는 자동 로또 티켓 개수를 반환한다.")
    void getAutoTicketCount() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(14000);
        int manualTicketCount = 0;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, manualTicketCount);
        //when //than
        assertThat(lottoMachine.getAutoTicketCount()).isEqualTo(14);
    }

}



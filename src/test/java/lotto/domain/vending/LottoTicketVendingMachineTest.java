package lotto.domain.vending;

import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketVendingMachineTest {

    @Test
    @DisplayName("구입 금액에 따라 로또 티켓을 여러 장 생성한다")
    void issue_tickets_from_buying_price() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(5000);
        LottoTicketVendingMachine lottoTicketVendingMachine = new LottoTicketVendingMachine();

        //when
        List<LottoTicket> tickets = lottoTicketVendingMachine.issueTickets(buyingPrice);

        //then
        assertThat(tickets).hasSize(5);
    }

}

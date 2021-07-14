package lotto.domain.vending;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketAmountTest {

    @ParameterizedTest
    @CsvSource(value = {"5000, 1, 4", "10000, 3, 7", "12000, 2, 10"})
    @DisplayName("구입 금액과 수동 로또 티켓 개수를 인자로 받아 로또 티켓 장수를 반환한다")
    void ticket_amount(int price, int manualCount, int exceptedAutoCount) {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(price);

        //when
        TicketAmount ticketAmount = new TicketAmount(buyingPrice, manualCount);

        //then
        assertThat(ticketAmount.manual()).isEqualTo(manualCount);
        assertThat(ticketAmount.auto()).isEqualTo(exceptedAutoCount);
    }
}

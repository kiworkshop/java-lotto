package lotto.domain.vending;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("전체 티켓 장수 보다 수동 구매 장수가 많은 경우 예외가 발생한다")
    void manual_ticket_amount_more_than_total_amount() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(5000);
        int manualTicketCount = 10;

        //when //then
        assertThatThrownBy(() -> new TicketAmount(buyingPrice, manualTicketCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

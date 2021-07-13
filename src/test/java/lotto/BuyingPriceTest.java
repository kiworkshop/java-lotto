package lotto;

import lotto.domain.BuyingPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BuyingPriceTest {

    @Test
    @DisplayName("구입 금액 값 객체를 생성한다")
    void create() {
        //given //when
        BuyingPrice buyingPrice = new BuyingPrice(1000);

        //then
        assertThat(buyingPrice).isEqualTo(new BuyingPrice(1000));
    }

    @Test
    @DisplayName("1000원 미만일 경우 예외가 발생한다")
    void validate_minimum() {
        //given
        int invalidPrice = 999;

        //when //then
        assertThatThrownBy(() -> new BuyingPrice(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000 단위가 아닐 경우 예외가 발생한다")
    void validate_factor() {
        //given
        int invalidPrice = 1001;

        //when //then
        assertThatThrownBy(() -> new BuyingPrice(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 티켓 금액으로 나눈 값을 반환한다")
    void divide_ticket_price() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(10000);

        //when
        int ticketAmount = buyingPrice.ticketAmount();

        //then
        assertThat(ticketAmount).isEqualTo(10);
    }
}

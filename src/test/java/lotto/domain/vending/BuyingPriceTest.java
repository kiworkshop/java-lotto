package lotto.domain.vending;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyingPriceTest {

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
    @DisplayName("1000원 단위가 아닐 경우 예외가 발생한다")
    void validate_factor() {
        //given
        int invalidPrice = 1001;

        //when //then
        assertThatThrownBy(() -> new BuyingPrice(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

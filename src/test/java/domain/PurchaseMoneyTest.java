package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseMoneyTest {

    @Test
    @DisplayName("구입금액을 생성하기 위해서는 1000원 이상이 필요하다.")
    void create() {
        //given
        int input = 999;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new PurchaseMoney(input));
    }

}
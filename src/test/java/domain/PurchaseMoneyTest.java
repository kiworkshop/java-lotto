package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("구매를 원하는 수동 티켓의 수를 입력하면 남은 돈으로 살 수 있는 자동 로또 티켓 개수를 반환한다.")
    void getAutoTicketCount() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(14000);
        int manualTicketCount = 0;
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, manualTicketCount);
        //when //than
        assertThat(purchaseMoney.getAutoTicketCount(manualTicketCount)).isEqualTo(14);
    }

}
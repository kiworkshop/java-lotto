package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 돈을_입력받으면_구매한_로또_수를_리턴한다() {

        //given
        int givenMoney = 14000;
        //when
        LottoMachine lottoMachine = new LottoMachine();
        int ticketNumber = lottoMachine.getLottoTickt(givenMoney);
        //than
        assertThat(ticketNumber).isEqualTo(14);
    }
}

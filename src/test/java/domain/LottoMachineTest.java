package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("돈을 입력받으면 구매할 수 있는 로또 티켓 개수를 반환한다.")
    void getLottoTicketCount() {
        //given
        int givenMoney = 14000;
        LottoMachine lottoMachine = new LottoMachine(givenMoney);
        //when //than
        assertThat(lottoMachine.getLottoTicketCount()).isEqualTo(14);
    }


    @Test
    @DisplayName("1부터 45사이의 숫자 중 중복되지 않는 6개를 뽑아 오름차순으로 반환한다.")
    void createNonDuplicateNumbers() {
        //given
        LottoMachine lottoMachine = new LottoMachine(1000);
        //when
        List<Integer> lottoNumbers = lottoMachine.createNonDuplicateNumbers();
        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);

    }

    @Test
    @DisplayName("부여받은 티켓 개수만큼 LottoTicket 을 생성한다.")
    void buyLottoTickets() {
        //given
        int money = 1000;
        LottoMachine lottoMachine = new LottoMachine(money);
        //when
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTickets();
        //then
        assertThat(lottoTickets.size()).isEqualTo(1);

    }

}



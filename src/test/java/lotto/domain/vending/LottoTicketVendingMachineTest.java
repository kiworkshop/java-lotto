package lotto.domain.vending;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketVendingMachineTest {

    private final LottoService lottoService = new LottoService();
    private final LottoTicketVendingMachine vendingMachine = new LottoTicketVendingMachine();

    @Test
    @DisplayName("6개의 로또 번호를 반환한다")
    void lotto_generator() {
        //given

        //when
        Set<LottoNumber> lottoNumbers = vendingMachine.issueAutoLottoNumbers();

        //then
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("자동으로 로또 티켓을 생성한다")
    void auto_issue_tickets() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(5000);
        TicketAmount ticketAmount = new TicketAmount(buyingPrice.totalTicketAmount(), 0);

        //when
        List<LottoTicket> tickets = vendingMachine.autoIssueTickets(ticketAmount.auto());

        //then
        assertThat(tickets).hasSize(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("수동으로 로또 티켓을 생성한다")
    void manual_issue_tickets(int index) {
        //given
        int manualCount = 3;
        List<List<Integer>> manualNumbers = generateManualNumbers(manualCount);

        //when
        List<LottoTicket> lottoTickets = vendingMachine.manualLottoTickets(manualNumbers);

        //then
        assertThat(lottoTickets.get(index).lottoNumbers()).isEqualTo(generateLottoTicket(index).lottoNumbers());
    }


    @Test
    @DisplayName("전체 로또 티켓을 생성한다")
    void total_lotto_tickets() {
        //given
        BuyingPrice buyingPrice = new BuyingPrice(8000);
        int manualCount = 3;
        TicketAmount ticketAmount = new TicketAmount(buyingPrice.totalTicketAmount(), manualCount);
        List<List<Integer>> manualNumbers = generateManualNumbers(manualCount);

        //when
        LottoTickets lottoTickets = vendingMachine.issueTickets(ticketAmount.auto(), manualNumbers);

        //then
        assertThat(lottoTickets.size()).isEqualTo(ticketAmount.total());
    }

    private List<List<Integer>> generateManualNumbers(int manualCount) {
        return IntStream.range(0, manualCount)
                .mapToObj(i -> Arrays.asList(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6))
                .collect(Collectors.toList());
    }

    private LottoTicket generateLottoTicket(int i) {
        return new LottoTicket(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6);
    }
}

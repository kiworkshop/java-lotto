package lotto.domain.vending;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketVendingMachineTest {

    private final LottoService lottoService = new LottoService();
    private final LottoTicketVendingMachine vendingMachine = new LottoTicketVendingMachine();

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
        List<String> inputManualLottoNumbers = generateManualNumbers(manualCount);
        List<List<Integer>> manualLottoNumbers = lottoService.manualLottoNumbers(inputManualLottoNumbers);

        //when
        List<LottoTicket> lottoTickets = vendingMachine.manualLottoTickets(manualLottoNumbers);

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
        List<String> inputManualNumbers = generateManualNumbers(manualCount);
        List<List<Integer>> manualLottoNumbers = lottoService.manualLottoNumbers(inputManualNumbers);

        //when\
        LottoTickets lottoTickets = vendingMachine.issueTickets(ticketAmount.auto(), manualLottoNumbers);

        //then
        assertThat(lottoTickets.size()).isEqualTo(ticketAmount.total());
    }

    private List<String> generateManualNumbers(int manualCount) {
        return IntStream.range(0, manualCount)
                .mapToObj(i -> String.format("%d, %d, %d, %d, %d, %d", i + 1, i + 2, i + 3, i + 4, i + 5, i + 6))
                .collect(Collectors.toList());
    }

    private LottoTicket generateLottoTicket(int i) {
        return new LottoTicket(i + 1, i + 2, i + 3, i + 4, i + 5, i + 6);
    }
}

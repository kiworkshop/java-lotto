package lotto.domain.winning;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.rank.WinningLottoRank;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.TicketAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.vending.BuyingPrice.TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsTest {
    private WinningNumbers generateWinningNumber(int bonusNumber) {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    @Test
    @DisplayName("당첨 순위의 수익률을 계산한다")
    void profit_rate() {
        //given
        LottoTickets lottoTickets = generateLottoTickets();
        BuyingPrice buyingPrice = new BuyingPrice(lottoTickets.size() * TICKET_PRICE);
        TicketAmount ticketAmount = new TicketAmount(buyingPrice.totalTicketAmount(), lottoTickets.size());

        WinningNumbers winningNumbers = generateWinningNumber(45);
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);

        //when
        WinningStatistics winningStatistics = new WinningStatistics(winningLottoRank);
        float profit = winningStatistics.profitRate(ticketAmount.total());

        //then
        assertThat(profit).isEqualTo(11.0f);
    }

    private LottoTickets generateLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(3, 4, 5, 6, 7, 8)); // 4개 일치
        lottoTickets.add(new LottoTicket(4, 5, 6, 7, 8, 9)); // 3개 일치
        lottoTickets.add(new LottoTicket(5, 6, 7, 8, 9, 10)); // 2개 일치
        lottoTickets.add(new LottoTicket(6, 7, 8, 9, 10, 11)); // 1개 일치
        lottoTickets.add(new LottoTicket(7, 8, 9, 10, 11, 12)); // 0개 일치
        return new LottoTickets(lottoTickets);
    }
}

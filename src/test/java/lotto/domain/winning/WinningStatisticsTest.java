package lotto.domain.winning;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.TicketAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.domain.vending.TicketAmount.TICKET_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {
    private WinningNumbers winningNumbers = generateWinningNumber();

    private WinningNumbers generateWinningNumber() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    @ParameterizedTest
    @MethodSource("generateLottoTicket")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다")
    void hit_winning_numbers_count(int[] numbers, int expectedCount) {
        //given
        LottoTicket lottoTicket = new LottoTicket(numbers);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 45);

        //when
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        int hitCount = winningStatistics.hitCount(lottoTicket);

        //then
        assertThat(hitCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("보너스 번호와 일치하는 로또 번호가 있는지 확인한다")
    void hit_bonus_number_count() {
        //given
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9), 1);

        //when
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        int hitBonus = winningStatistics.hitBonus(lottoTicket);

        //then
        assertThat(hitBonus).isEqualTo(1);
    }

    private static Stream<Arguments> generateLottoTicket() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 7, 8}, 4),
                Arguments.of(new int[]{1, 2, 3, 7, 8, 9}, 3),
                Arguments.of(new int[]{1, 2, 7, 8, 9, 10}, 2),
                Arguments.of(new int[]{1, 7, 8, 9, 10, 11}, 1),
                Arguments.of(new int[]{8, 9, 10, 11, 12, 13}, 0)
        );
    }

    @Test
    @DisplayName("당첨 번호 개수가 같은 로또 티켓 개수를 반환한다")
    void group_by_matched_count() {
        //given
        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        LottoTickets lottoTickets = generateLottoTickets();

        //when
        Map<LottoRank, Integer> ranks = winningStatistics.groupByHitCount(lottoTickets);

        //thenR
        assertThat(ranks.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(ranks.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(ranks.get(LottoRank.THIRD)).isZero();
        assertThat(ranks.get(LottoRank.FIRST)).isZero();
    }

    @Test
    @DisplayName("당첨 순위의 수익률을 계산한다")
    void profit_rate() {
        //given
        LottoTickets lottoTickets = generateLottoTickets();
        BuyingPrice buyingPrice = new BuyingPrice(lottoTickets.size() * TICKET_PRICE);
        TicketAmount ticketAmount = new TicketAmount(buyingPrice, lottoTickets.size());

        WinningStatistics winningStatistics = new WinningStatistics(winningNumbers);
        Map<LottoRank, Integer> ranks = winningStatistics.groupByHitCount(lottoTickets);

        //when
        float profit = winningStatistics.profitRate(ticketAmount, ranks);

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

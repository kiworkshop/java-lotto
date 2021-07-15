package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
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

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoRankTest {

    private WinningNumbers generateWinningNumber(int bonusNumber) {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return new WinningNumbers(inputNumbers, bonusNumber);
    }

    @ParameterizedTest
    @MethodSource("hitLottoNumbers")
    @DisplayName("당첨 번호와 일치하는 로또 번호 개수를 반환한다")
    void hit_winning_numbers_count(int[] numbers, int expectedCount) {
        //given
        LottoTicket lottoTicket = new LottoTicket(numbers);
        LottoTickets lottoTickets = new LottoTickets(lottoTicket);
        WinningNumbers winningNumbers = generateWinningNumber(45);

        //when
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
        int hitCount = winningLottoRank.hitCount(lottoTicket);

        //then
        assertThat(hitCount).isEqualTo(expectedCount);
    }

    @Test
    @DisplayName("보너스 번호 일치하는 로또 번호 개수를 반환한다")
    void hit_bonus_number_count() {
        //given
        LottoTicket lottoTicket = new LottoTicket(5, 10, 15, 20, 25, 30);
        LottoTickets lottoTickets = new LottoTickets(lottoTicket);
        WinningNumbers winningNumbers = generateWinningNumber(30);

        //when
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
        int hitBonus = winningLottoRank.hitBonus(lottoTicket);

        //then
        assertThat(hitBonus).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호 개수가 같은 로또 티켓 개수를 반환한다")
    void group_by_rank_count() {
        //given
        WinningNumbers winningNumbers = generateWinningNumber(45);
        LottoTickets lottoTickets = generateLottoTickets();

        //when
        WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);

        //thenR
        assertThat(winningLottoRank.count(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(winningLottoRank.count(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(winningLottoRank.count(LottoRank.THIRD)).isZero();
        assertThat(winningLottoRank.count(LottoRank.FIRST)).isZero();
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

    private static Stream<Arguments> hitLottoNumbers() {
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
}

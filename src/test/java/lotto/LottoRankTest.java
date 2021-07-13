package lotto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6, 0, FIRST", "5, 1, SECOND", "5, 0, THIRD", "4, 0, FOURTH", "3, 0, FIFTH"})
    @DisplayName("로또 티켓의 당첨 갯수에 따른 순위를 반환한다")
    void lotto_hit_count_rank(int hitCount, int hitBonus, String ranking) {
        //given

        //when
        LottoRank rank = LottoRank.findBy(hitCount, hitBonus);

        //then
        assertThat(rank).isEqualTo(LottoRank.valueOf(ranking));
    }
}

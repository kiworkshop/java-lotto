package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, false, FOURTH", "3, false, FIFTH"})
    @DisplayName("로또 티의 당첨 갯수개에 따른 순위를 반환한다")
    void lotto_hit_count_rank(int hitCount, boolean hitBonus, String ranking) {
        //given

        //when
        LottoRank rank = LottoRank.findBy(hitCount, hitBonus);

        //then
        assertThat(rank).isEqualTo(LottoRank.valueOf(ranking));
    }
}

package domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void rankValueOf() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(2)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(0)).isEqualTo(Rank.MISS);

        assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0);
    }
}
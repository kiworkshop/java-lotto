package domain.result;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class UserRanksTest {

    @Test
    void testUserRanks() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.SECOND);
        ranks.add(Rank.THIRD);
        ranks.add(Rank.FOURTH);

        UserRanks userRanks = new UserRanks(ranks);

        assertThat(userRanks.getRanks()).size().isEqualTo(4);
    }

    @Test
    void testUserRanksProfit() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FOURTH);
        ranks.add(Rank.MISS);
        ranks.add(Rank.MISS);
        ranks.add(Rank.MISS);
        ranks.add(Rank.MISS);

        UserRanks userRanks = new UserRanks(ranks);

        assertThat(userRanks.getProfitRate()).isEqualTo(0);
    }

    @Test
    void testCountRanks() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.SECOND);
        ranks.add(Rank.SECOND);
        ranks.add(Rank.FOURTH);
        ranks.add(Rank.THIRD);
        ranks.add(Rank.FOURTH);

        UserRanks userRanks = new UserRanks(ranks);

        assertThat(userRanks.count(Rank.SECOND)).isEqualTo(2);
        assertThat(userRanks.count(Rank.FOURTH)).isEqualTo(2);
        assertThat(userRanks.count(Rank.THIRD)).isEqualTo(1);

    }
}
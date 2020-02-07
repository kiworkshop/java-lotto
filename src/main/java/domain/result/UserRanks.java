package domain.result;

import java.util.List;

public class UserRanks {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final double PERCENTAGE = 100d;

    private List<Rank> ranks;

    public UserRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public double getProfitRate() {
        double totalProfit = ranks.stream().mapToDouble(Rank::getWinningMoney).sum();
        return totalProfit / (ranks.size() * PRICE_PER_LOTTO) * PERCENTAGE;
    }

    public int count(Rank rank) {
        return (int) ranks.stream().filter(rank::equals).count();
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}

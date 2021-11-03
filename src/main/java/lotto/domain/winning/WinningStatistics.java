package lotto.domain.winning;

import lotto.domain.rank.WinningLottoRank;

import static lotto.domain.vending.BuyingPrice.TICKET_PRICE;

public class WinningStatistics {
    private final WinningLottoRank winningLottoRank;

    public WinningStatistics(WinningLottoRank winningLottoRank) {
        this.winningLottoRank = winningLottoRank;
    }

    public float profitRate(int totalTicketAmount) {
        int totalPrize = totalPrize();
        return (float) totalPrize / (totalTicketAmount * TICKET_PRICE);
    }

    private int totalPrize() {
        return winningLottoRank.keys().stream()
                .mapToInt(rank -> rank.prizeMoney() * winningLottoRank.count(rank))
                .sum();
    }
}

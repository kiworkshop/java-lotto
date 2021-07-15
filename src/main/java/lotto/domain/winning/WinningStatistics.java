package lotto.domain.winning;

import lotto.domain.vending.TicketAmount;

import static lotto.domain.vending.TicketAmount.TICKET_PRICE;

public class WinningStatistics {
    private final WinningLottoRank winningLottoRank;

    public WinningStatistics(WinningLottoRank winningLottoRank) {
        this.winningLottoRank = winningLottoRank;
    }

    public float profitRate(TicketAmount ticketAmount) {
        int totalPrize = totalPrize();
        return (float) totalPrize / (ticketAmount.total() * TICKET_PRICE);
    }

    private int totalPrize() {
        return winningLottoRank.keys().stream()
                .mapToInt(rank -> rank.prizeMoney() * winningLottoRank.count(rank))
                .sum();
    }
}

package lotto.domain;

import java.util.*;

import static lotto.domain.BuyingPrice.TICKET_PRICE;

public class WinningStatistics {
    private final WinningNumbers winningNumbers;
    private final Map<LottoRank, Integer> ranks = new LinkedHashMap<>();

    public WinningStatistics(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        initRank();
    }

    private void initRank() {
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .filter(v -> v.getHitCount() > LottoRank.LOSE.getHitCount())
                .forEach(rank -> ranks.put(rank, 0));
    }

    public int hitCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.getWinningNumbers().stream()
                .filter(winningNumber -> lottoTicket.contains(winningNumber))
                .count();
    }

    public int hitBonus(LottoTicket lottoTicket) {
        return lottoTicket.contains(winningNumbers.getBonusNumber()) ? 1 : 0;
    }

    public Map<LottoRank, Integer> groupByHitCount(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
                .filter(lottoTicket -> hitCount(lottoTicket) >= LottoRank.FIFTH.getHitCount())
                .forEach(lottoTicket -> {
                    LottoRank key = LottoRank.findBy(hitCount(lottoTicket), hitBonus(lottoTicket));
                    ranks.put(key, ranks.get(key) + 1);
                });
        return ranks;
    }

    public float profitRate(int ticketAmount, Map<LottoRank, Integer> ranks) {
        int totalPrize = totalPrize(ranks);
        return (float) totalPrize / (ticketAmount * TICKET_PRICE);
    }

    private int totalPrize(Map<LottoRank, Integer> ranks) {
        return ranks.keySet().stream()
                .mapToInt(lottoRank -> lottoRank.getPrizeMoney() * ranks.get(lottoRank))
                .sum();
    }

}

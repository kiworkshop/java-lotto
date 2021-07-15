package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.*;

public class WinningLottoRank {
    private final WinningNumbers winningNumbers;
    private final Map<LottoRank, Integer> winningLottoRank;

    public WinningLottoRank(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.winningLottoRank = new LinkedHashMap<>();
        initRank(lottoTickets);
    }

    private void initRank(LottoTickets lottoTickets) {
        Arrays.stream(LottoRank.values())
                .forEach(rank -> winningLottoRank.put(rank, 0));
        groupByWinningCount(lottoTickets);
    }

    private void groupByWinningCount(LottoTickets lottoTickets) {
        lottoTickets.values().stream()
                .forEach(lottoTicket -> addWinningCount(lottoTicket));
        winningLottoRank.remove(LottoRank.LOSE);
    }

    public int hitCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.getWinningNumbers().stream()
                .filter(winningNumber -> lottoTicket.contains(winningNumber))
                .count();
    }

    public boolean hitBonus(LottoTicket lottoTicket) {
        return lottoTicket.contains(winningNumbers.getBonusNumber());
    }

    private void addWinningCount(LottoTicket lottoTicket) {
        LottoRank key = LottoRank.findBy(hitCount(lottoTicket), hitBonus(lottoTicket));
        winningLottoRank.put(key, winningLottoRank.get(key) + 1);
    }

    public int count(LottoRank lottoRank) {
        return winningLottoRank.get(lottoRank);
    }

    public Set<LottoRank> keys() {
        return winningLottoRank.keySet();
    }
}

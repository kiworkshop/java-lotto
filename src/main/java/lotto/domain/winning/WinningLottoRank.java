package lotto.domain.winning;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

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
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> winningLottoRank.put(rank, 0));
        groupByWinningCount(lottoTickets);
    }


    public int hitCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.getWinningNumbers().stream()
                .filter(winningNumber -> lottoTicket.contains(winningNumber))
                .count();
    }

    public int hitBonus(LottoTicket lottoTicket) {
        return lottoTicket.contains(winningNumbers.getBonusNumber()) ? 1 : 0;
    }

    public void groupByWinningCount(LottoTickets lottoTickets) {
        lottoTickets.values().stream()
                .filter(lottoTicket -> hitCount(lottoTicket) >= LottoRank.FIFTH.hitCount())
                .forEach(lottoTicket -> {
                    LottoRank key = LottoRank.findBy(hitCount(lottoTicket), hitBonus(lottoTicket));
                    winningLottoRank.put(key, winningLottoRank.get(key) + 1);
                });
    }

    public int count(LottoRank lottoRank) {
        return winningLottoRank.get(lottoRank);
    }
}

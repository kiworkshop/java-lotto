package lotto.domain;

import lotto.enums.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Rank, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(Function.identity(), count -> 0));
    }

    public Map<Rank, Integer> getLottoResult(List<LottoTicket> purchasedLottoTickets, WinningLotto winningLotto) {
        for (LottoTicket lottoticket : purchasedLottoTickets) {
            addLottoRankCount(winningLotto.getRank(lottoticket));
        }
        return this.lottoResult;
    }

    private void addLottoRankCount(Optional<Rank> rank) {
        if (rank.isPresent()) {
            lottoResult.put(rank.get(), lottoResult.get(rank.get()) + 1);
        }
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getProfitRate(PurchaseMoney purchaseMoney, Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble(rank -> rank.getKey().getPrize() * rank.getValue())
                .sum();
        return totalPrize / purchaseMoney.getMoneyValue();
    }
}

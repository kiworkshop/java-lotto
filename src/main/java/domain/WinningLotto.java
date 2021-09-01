package domain;

import enums.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static domain.LottoTicket.LOTTO_NUMBERS_SIZE;

public class WinningLotto {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new HashSet<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(LottoTicket purchasedLottoTicket) {
        int matchCount = countOfMatches(purchasedLottoTicket);
        int bonusCount = countOfBonusMatch(purchasedLottoTicket);
        return Rank.getRank(matchCount, bonusCount);
    }

    private int countOfMatches(LottoTicket purchasedLottoTicket) {
        Set<Integer> purchasedTicket = new HashSet<>(purchasedLottoTicket.getLottoTicketNumbers());
        purchasedTicket.removeAll(winningNumbers);
        return LOTTO_NUMBERS_SIZE - purchasedTicket.size();
    }

    private int countOfBonusMatch(LottoTicket purchasedLottoTicket) {
        return (purchasedLottoTicket.getLottoTicketNumbers().contains(bonusNumber) ? 1 : 0);
    }
}

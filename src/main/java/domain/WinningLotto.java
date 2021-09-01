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
        // winningNumbers + purchasedNumbers = 12
        // set에 넣어서 8개
        // 중복된 number가 4개 -> match된 number. 얘를 리턴
        Set<Integer> set = new HashSet<>(purchasedLottoTicket.getLottoTicketNumbers());
        set.addAll(winningNumbers);
        return winningNumbers.size() + purchasedLottoTicket.getLottoTicketNumbers().size() - set.size();
    }

    private int countOfMatches2(LottoTicket purchasedLottoTicket) {
        Set<Integer> purchasedTicket = new HashSet<>(purchasedLottoTicket.getLottoTicketNumbers());
        purchasedTicket.removeAll(winningNumbers);
        return LOTTO_NUMBERS_SIZE - purchasedTicket.size();
    }

    private int countOfBonusMatch(LottoTicket purchasedLottoTicket) {
        return (purchasedLottoTicket.getLottoTicketNumbers().contains(bonusNumber) ? 1 : 0);
    }
}

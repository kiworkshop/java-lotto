package lotto.domain;

import lotto.enums.Rank;

import java.util.List;
import java.util.Optional;

public class WinningLotto {

    private static final String ALERT_CHECK_BONUS_DUPLICATE = "보너스볼이 당첨 번호와 중복되는지 확인해주세요.";

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        checkBonusDuplicate(winningTicket, bonusNumber);
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void checkBonusDuplicate(LottoTicket winningTicket, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = winningTicket.getLottoTicketNumbers();

        if (isDuplicate(lottoNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ALERT_CHECK_BONUS_DUPLICATE);
        }
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(number -> bonusNumber == number);
    }

    public Optional<Rank> getRank(LottoTicket purchasedLottoTicket) {
        int matchCount = purchasedLottoTicket.countOfMatches(winningTicket);
        int bonusCount = purchasedLottoTicket.countOfBonusMatch(bonusNumber);
        return Rank.getRank(matchCount, bonusCount);
    }
}

package domain;

import enums.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static domain.LottoTicket.LOTTO_NUMBERS_SIZE;

public class WinningLotto {

    private static final String ALERT_CHECK_LOTTO_NUMBER_SIZE = String.format("당첨번호는 %d개 이어야 합니다.", LOTTO_NUMBERS_SIZE);
    private static final String ALERT_CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private static final String ALERT_CHECK_BONUS_DUPLICATE = "보너스볼이 당첨 번호와 중복되는지 확인해주세요.";

    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = new HashSet<>(winningNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList()));
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        checkLength(winningNumbers);
        checkDuplicate(winningNumbers);
        checkBonusDuplicate(winningNumbers, bonusNumber);
    }

    private void checkLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ALERT_CHECK_LOTTO_NUMBER_SIZE);

        }
    }

    private void checkDuplicate(List<Integer> winningNumbers) {
        int countOfDeDuplication = (int) winningNumbers.stream()
                .distinct()
                .count();

        if (countOfDeDuplication != winningNumbers.size()) {
            throw new IllegalArgumentException(ALERT_CHECK_DUPLICATION);
        }
    }

    private void checkBonusDuplicate(List<Integer> winningNumber, int bonusInputNumber) {
        boolean isDuplicate = winningNumber.stream()
                .anyMatch(number -> bonusInputNumber == number);

        if (isDuplicate) {
            throw new IllegalArgumentException(ALERT_CHECK_BONUS_DUPLICATE);
        }
    }

    public Optional<Rank> getRank(LottoTicket purchasedLottoTicket) {
        int matchCount = countOfMatches(purchasedLottoTicket);
        int bonusCount = countOfBonusMatch(purchasedLottoTicket);
        return Rank.getRank(matchCount, bonusCount);
    }

    private int countOfMatches(LottoTicket purchasedLottoTicket) {
        Set<LottoNumber> purchasedTicket = new HashSet<>(purchasedLottoTicket.getLottoTicketNumbers());
        purchasedTicket.removeAll(winningNumbers);
        return LOTTO_NUMBERS_SIZE - purchasedTicket.size();
    }

    private int countOfBonusMatch(LottoTicket purchasedLottoTicket) {
        return (purchasedLottoTicket.getLottoTicketNumbers().contains(bonusNumber) ? 1 : 0);
    }
}

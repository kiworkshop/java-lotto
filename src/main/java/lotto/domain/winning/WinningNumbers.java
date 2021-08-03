package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateSize(winningNumbers.size());
        validateDuplication(new HashSet<>(winningNumbers), bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this(winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }

    private void validateSize(int winningNumberSize) {
        if (winningNumberSize != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("수동 로또 번호 입력 개수는 6개 입니다.");
        }
    }

    private void validateDuplication(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.size() < LOTTO_NUMBER_SIZE || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호가 중복됩니다.");
        }
    }

    public int hitCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    public boolean hitBonus(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}

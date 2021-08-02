package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateSize(winningNumbers.size());
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this(winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }

    private void validateSize(int winningNumberSize) {
        if (winningNumberSize > WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("수동 로또 번호 입력 개수는 6개 입니다.");
        }
    }

    private void validateDuplication(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(winningNumbers);

        if (lottoNumbers.size() < WINNING_NUMBER_SIZE || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호가 중복됩니다.");
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}

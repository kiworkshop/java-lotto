package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개로 이뤄져 있습니다.");
        }
    }

    public List<Integer> getLottoTicketNumbers() {
        return numbers;
    }

    public String getLottoTicketString() {
        String LotteryTicket = "[";
        for (int i = 0; i < LOTTO_NUMBERS_SIZE - 1; i++) {
            LotteryTicket = LotteryTicket + numbers.get(i) + ", ";
        }
        LotteryTicket = LotteryTicket + numbers.get(LOTTO_NUMBERS_SIZE - 1) + "]";
        return LotteryTicket;
    }
}

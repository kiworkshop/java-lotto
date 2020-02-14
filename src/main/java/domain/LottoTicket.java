package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_PICK_NUMBER = 6;

    private List<Integer> numbers = new ArrayList<>();

    public LottoTicket ofRandom() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        for (int i = 0; i < LOTTO_PICK_NUMBER; i++) {
            numbers.add(lottoNumbers.get(i));
        }
        return this;
    }

    public LottoTicket ofGiven(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        return this;
    }

    public int getNumMatchingNumbers(List<Integer> numbers) {
        int numMatchingNumbers = 0;
        for (int number: numbers) {
            if (this.numbers.contains(number)) {
                numMatchingNumbers++;
            }
        }
        return numMatchingNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

package domain.lotto.ticket;

import domain.lotto.LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    protected List<Integer> chosenNumbers = new ArrayList<>();

    public LottoTicket ofRandom() {
        List<Integer> lottoNumbers =
                IntStream.rangeClosed(LottoGame.MIN_LOTTO_NUMBER, LottoGame.MAX_LOTTO_NUMBER)
                .boxed().collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        for (int i = 0; i < LottoGame.NUMBER_OF_BALLS; i++) {
            chosenNumbers.add(lottoNumbers.get(i));
        }
        return this;
    }

    public LottoTicket ofGiven(List<Integer> numbers) {
        this.chosenNumbers.addAll(numbers);
        return this;
    }

    public int getNumMatchingNumbers(List<Integer> numbers) {
        int numMatchingNumbers = 0;
        for (int number: numbers) {
            if (this.chosenNumbers.contains(number)) {
                numMatchingNumbers++;
            }
        }
        return numMatchingNumbers;
    }

    @Override
    public String toString() {
        return chosenNumbers.toString();
    }

    public List<Integer> getChosenNumbers() {
        return chosenNumbers;
    }
}

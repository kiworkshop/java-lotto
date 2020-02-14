package domain.lotto.ticket;

import domain.lotto.LottoGame;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLottoTicket extends LottoTicket {

    public UserLottoTicket ofRandom() {
        List<Integer> lottoNumbers =
                IntStream.rangeClosed(LottoGame.MIN_LOTTO_NUMBER, LottoGame.MAX_LOTTO_NUMBER)
                        .boxed().collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        for (int i = 0; i < LottoGame.NUMBER_OF_BALLS; i++) {
            chosenNumbers.add(lottoNumbers.get(i));
        }
        return this;
    }

    public UserLottoTicket ofGiven(List<Integer> numbers) {
        this.chosenNumbers.addAll(numbers);
        return this;
    }
}

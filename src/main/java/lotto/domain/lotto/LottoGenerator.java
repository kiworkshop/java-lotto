package lotto.domain.lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_BOUND;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_BOUND;
import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE;

public class LottoGenerator {
    private final List<LottoNumber> lottoNumberBox;

    public LottoGenerator() {
        this.lottoNumberBox = create();
        Collections.shuffle(lottoNumberBox);
    }

    private List<LottoNumber> create() {
        return IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> issueAutoLottoNumbers() {
        return lottoNumberBox.subList(0, LOTTO_NUMBER_SIZE).stream()
                .sorted(Comparator.comparing(LottoNumber::value))
                .collect(Collectors.toList());
    }
}

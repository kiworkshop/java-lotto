package lotto.domain.lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_BOUND;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_BOUND;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBER_CONTAINER = create();

    private static List<LottoNumber> create() {
        return IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> issueAutoLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_CONTAINER);
        return LOTTO_NUMBER_CONTAINER.subList(0, 6).stream()
                .sorted(Comparator.comparing(LottoNumber::value))
                .collect(Collectors.toList());
    }
}

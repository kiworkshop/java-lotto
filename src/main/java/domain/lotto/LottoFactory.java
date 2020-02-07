package domain.lotto;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoFactory {

    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static Lotto publishLotto() {
        return Lotto.from(getLottoNumbers());
    }

    private static Set<LottoNumber> getLottoNumbers() {
        return new Random().ints(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
                .distinct()
                .limit(6)
                .sorted()
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());
    }
}

package lotto.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final int INDEX_LOWER_BOUND = 0;
    private static final int INDEX_UPPER_BOUND = 6;

    @Getter
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto generateRandomLotto() {
        List<Integer> defaultNumbers = new ArrayList<>(DefaultNumbers.getDefaultNumbers());
        Collections.shuffle(defaultNumbers);
        return new Lotto(defaultNumbers.subList(INDEX_LOWER_BOUND, INDEX_UPPER_BOUND)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}

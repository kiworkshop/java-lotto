package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLotto extends Lotto {

    private static final int INDEX_LOWER_BOUND = 0;
    private static final int INDEX_UPPER_BOUND = 6;
    private static final List<Integer> DEFAULT_NUMBERS = Collections.unmodifiableList(new ArrayList<Integer>() {{
        IntStream.range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .forEach(this::add);
    }});

    public RandomLotto() {
        super(generateRandomLottoNumbers());
    }

    private static List<LottoNumber> generateRandomLottoNumbers() throws IllegalArgumentException {
        List<Integer> defaultNumbers = new ArrayList<>(DEFAULT_NUMBERS);
        Collections.shuffle(defaultNumbers);
        return defaultNumbers.subList(INDEX_LOWER_BOUND, INDEX_UPPER_BOUND)
                .stream()
                .map(String::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

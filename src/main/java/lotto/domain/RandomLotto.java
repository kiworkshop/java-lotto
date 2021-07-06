package lotto.domain;

import lombok.Getter;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class RandomLotto extends Lotto {
    private static final int INDEX_LOWER_BOUND = 0;
    private static final int INDEX_UPPER_BOUND = 6;

    public RandomLotto() {
        super(generateRandomLottoNumbers());
    }

    private static List<LottoNumber> generateRandomLottoNumbers() {
        ArrayList<Integer> defaultNumberSet = new ArrayList<>();
        for (int i = 0; i < 44; i++) {
            defaultNumberSet.add(i+1);
        }

        Collections.shuffle(defaultNumberSet);
        return defaultNumberSet.subList(INDEX_LOWER_BOUND, INDEX_UPPER_BOUND)
                .stream()
                .map(String::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

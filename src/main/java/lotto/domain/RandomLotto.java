package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RandomLotto extends Lotto {
    private static final int INDEX_LOWER_BOUND = 0;
    private static final int INDEX_UPPER_BOUND = 6;

    public RandomLotto() {
        super(generateRandomLottoNumbers());

    }

    public static List<LottoNumber> generateRandomLottoNumbers() {
        List<LottoNumber> returnList = new ArrayList<>();
        List<Integer> defaultNumbers = new ArrayList<>(DefaultNumbers.getDefaultNumbers());
        Collections.shuffle(defaultNumbers);
        defaultNumbers.subList(INDEX_LOWER_BOUND, INDEX_UPPER_BOUND).stream()
                .map(LottoNumber::new)
                .forEach(returnList::add);
        return returnList;
    }
}

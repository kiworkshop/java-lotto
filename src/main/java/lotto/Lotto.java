package lotto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Lotto {
    private static final int INDEX_LOWER_BOUND = 0;
    private static final int INDEX_UPPER_BOUND = 6;

    private final List<Integer> lotto;

    public Lotto() {
        ArrayList<Integer> defaultNumberSet = new ArrayList<>();
        for (int i = 0; i < 44; i++) {
            defaultNumberSet.add(i+1);
        }

        Collections.shuffle(defaultNumberSet);
        this.lotto = defaultNumberSet.subList(INDEX_LOWER_BOUND, INDEX_UPPER_BOUND);
    }
}

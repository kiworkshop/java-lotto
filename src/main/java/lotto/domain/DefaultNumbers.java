package lotto.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class DefaultNumbers {
    @Getter
    private static final List<Integer> defaultNumbers = Collections.unmodifiableList(new ArrayList<Integer>() {{
        IntStream
                .range(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .forEach(this::add);
    }});
}

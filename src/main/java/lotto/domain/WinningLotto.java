package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {

    public WinningLotto(String input) {
        super(Arrays.stream(input.split(","))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}

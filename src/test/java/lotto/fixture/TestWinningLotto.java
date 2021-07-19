package lotto.fixture;

import lotto.domain.WinningLotto;
import lotto.domain.dto.WinningLottoInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestWinningLotto extends WinningLotto {

    private static final List<Integer> winningNumberInput = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
            .boxed()
            .collect(Collectors.toList());
    private static final Integer bonusNumberInput = 7;

    public TestWinningLotto() {
        super(WinningLottoInput.builder()
                .numbers(winningNumberInput)
                .bonus(bonusNumberInput)
                .build());
    }
}

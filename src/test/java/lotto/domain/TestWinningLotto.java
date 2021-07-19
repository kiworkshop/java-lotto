package lotto.domain;

import lotto.domain.dto.WinningLottoInput;

public class TestWinningLotto extends WinningLotto {

    private static final String winningNumberInput = "1, 2, 3, 4, 5, 6";
    private static final String bonusNumberInput = "7";

    public TestWinningLotto() {
        super(WinningLottoInput.builder()
                .winningLottoNumbers(winningNumberInput)
                .winningLottoBonus(bonusNumberInput)
                .build());
    }
}

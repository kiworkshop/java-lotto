package lotto.domain;

import lombok.Getter;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {

    @Getter
    private LottoNumber bonusNumber;

    public WinningLotto(String winningNumberInput, String bonusNumberInput) {
        super(Arrays.stream(winningNumberInput.split(","))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        this.bonusNumber = new LottoNumber(bonusNumberInput);
    }
}

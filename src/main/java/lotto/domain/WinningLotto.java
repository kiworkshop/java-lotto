package lotto.domain;

import lombok.Builder;
import lombok.Getter;
import lotto.domain.dto.WinningLottoInput;

public class WinningLotto extends Lotto {

    @Getter
    private final LottoNumber bonusNumber;

    @Builder
    public WinningLotto(WinningLottoInput winningLottoInput) throws IllegalArgumentException {
        super(winningLottoInput.getNumbers());
        this.bonusNumber = new LottoNumber(winningLottoInput.getBonus());
    }
}

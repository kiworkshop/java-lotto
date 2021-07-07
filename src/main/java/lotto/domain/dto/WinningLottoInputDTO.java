package lotto.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class WinningLottoInputDTO {

    private final String winningLottoNumbers;
    private final String winningLottoBonus;
}

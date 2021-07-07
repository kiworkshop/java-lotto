package lotto.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class WinningLottoInputDTO {

    private final String winningLottoNumbers;
    private final String winningLottoBonus;
}

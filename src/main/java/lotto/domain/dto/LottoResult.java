package lotto.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lotto.domain.PrizeCount;

@Getter
@RequiredArgsConstructor
@Builder
public class LottoResult {

    private final PrizeCount prizeCount;
    private final double profitRate;
}

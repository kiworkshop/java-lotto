package lotto.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lotto.domain.LottoSet;
import lotto.domain.PurchaseCount;

@Getter
@RequiredArgsConstructor
@Builder
public class PurchaseResult {

    private final PurchaseCount purchaseCount;
    private final LottoSet lottoSet;
}

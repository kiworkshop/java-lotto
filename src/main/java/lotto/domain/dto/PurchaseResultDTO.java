package lotto.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lotto.domain.PurchaseCount;
import lotto.domain.RandomLottoSet;

@Getter
@RequiredArgsConstructor
@Builder
public class PurchaseResultDTO {

    private final PurchaseCount purchaseCount;
    private final RandomLottoSet randomLottoSet;
}

package lotto.view;

import lotto.domain.LottoSet;
import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseCount;
import lotto.domain.dto.ManualLottoNumberInputDTO;
import lotto.domain.dto.ManualPurchaseCountDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;

public interface View {
    PurchasePriceInputDTO getPurchaseCost();
    WinningLottoInputDTO getWinningLottoAndBonus();
    void printLottoCount(ManualLottoNumberInputDTO manualLottoNumberInput, PurchaseCount purchaseCount);
    void printLottoSet(LottoSet lottoSet);
    void printLottoStatistics(LottoStatistics lottoStatistics);
    ManualPurchaseCountDTO getManualPurchaseCount();
    ManualLottoNumberInputDTO getManualLottoNumbers(ManualPurchaseCountDTO manualPurchaseCountDTO);
}

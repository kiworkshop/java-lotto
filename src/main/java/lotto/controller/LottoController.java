package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.ManualLottoNumberInputDTO;
import lotto.domain.dto.ManualPurchaseCountDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.view.View;

public class LottoController {
    public static void run() {
        View view = new View();
        PurchasePriceInputDTO purchasePriceInputDTO = view.getPurchaseCost();

        ManualPurchaseCountDTO manualPurchaseCountDTO = view.getManualPurchaseCount();

        ManualLottoNumberInputDTO manualLottoNumberInputDTO = view.getManualLottoNumbers(Integer.parseInt(manualPurchaseCountDTO.getInput()));

        PurchaseCount randomPurchaseCount = new PurchaseCount(purchasePriceInputDTO, manualPurchaseCountDTO);
        LottoSet mixedLottoSet = LottoSet.generateMixedLottoSet(manualLottoNumberInputDTO, randomPurchaseCount);

        view.printLottoCount(manualLottoNumberInputDTO, randomPurchaseCount);
        view.printLottoSet(mixedLottoSet);

        WinningLottoInputDTO winningLottoInputDTO = view.getWinningLottoAndBonus();
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        LottoStatistics lottoStatistics = new LottoStatistics(new PrizeCount(mixedLottoSet, winningLotto), randomPurchaseCount);
        view.printLottoStatistics(lottoStatistics);
    }


}

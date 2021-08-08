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
        validateManualPurchaseCountInputNotOver(purchasePriceInputDTO, manualPurchaseCountDTO);

        ManualLottoNumberInputDTO manualLottoNumberInputDTO = view.getManualLottoNumbers(manualPurchaseCountDTO);

        PurchaseCount randomPurchaseCount = new PurchaseCount(purchasePriceInputDTO, manualPurchaseCountDTO);
        LottoSet mixedLottoSet = LottoSet.generateMixedLottoSet(manualLottoNumberInputDTO, randomPurchaseCount);

        view.printLottoCount(manualLottoNumberInputDTO, randomPurchaseCount);
        view.printLottoSet(mixedLottoSet);

        WinningLottoInputDTO winningLottoInputDTO = view.getWinningLottoAndBonus();
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        LottoStatistics lottoStatistics = new LottoStatistics(new PrizeCount(mixedLottoSet, winningLotto), randomPurchaseCount);
        view.printLottoStatistics(lottoStatistics);
    }

    private static void validateManualPurchaseCountInputNotOver(PurchasePriceInputDTO purchasePriceInputDTO, ManualPurchaseCountDTO manualPurchaseCountDTO) {
        int wholePurchaseCount = Integer.parseInt(purchasePriceInputDTO.getInput()) / Lotto.PRICE;
        int manualPurchaseCount = Integer.parseInt(manualPurchaseCountDTO.getInput());

        if(manualPurchaseCount > wholePurchaseCount) {
            throw new IllegalArgumentException("수동 구매금액이 전체 구매금액을 초과했습니다.");
        }
    }


}

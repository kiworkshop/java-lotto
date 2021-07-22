package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.view.View;

public class LottoController {
    public static void main(String[] args) {
        View view = new View();
        PurchasePriceInputDTO purchasePriceInputDTO = view.getPurchaseCost();

        PurchaseCount purchaseCount = new PurchaseCount(purchasePriceInputDTO.getInput());
        LottoSet randomLottoSet = LottoSet.generateRandomLottoSetWithSize(purchaseCount.getPurchaseCount());

        view.printLottoCount(purchaseCount);
        view.printLottoSet(randomLottoSet);

        WinningLottoInputDTO winningLottoInputDTO = view.getWinningLottoAndBonus();
        WinningLotto winningLotto = new WinningLotto(winningLottoInputDTO);
        LottoStatistics lottoStatistics = new LottoStatistics(new PrizeCount(randomLottoSet, winningLotto), purchaseCount);
        view.printLottoStatistics(lottoStatistics);
    }
}

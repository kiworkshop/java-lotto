package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.view.View;

public class LottoController {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        PurchasePriceInputDTO purchasePriceInputDTO = View.getPurchaseCost();

        PurchaseCount purchaseCount = new PurchaseCount(purchasePriceInputDTO.getInput());
        RandomLottoSet randomLottoSet = new RandomLottoSet(purchaseCount);

        View.printLottoCount(purchaseCount);
        View.printLottoSet(randomLottoSet);

        WinningLottoInputDTO winningLottoInputDTO = View.getWinningLottoAndBonus();
        WinningLotto winningLotto = new WinningLotto(
                winningLottoInputDTO.getWinningLottoNumbers(),
                winningLottoInputDTO.getWinningLottoBonus());

        LottoStatistics lottoStatistics = new LottoStatistics(new PrizeCount(randomLottoSet, winningLotto), purchaseCount);
        View.printLottoStatistics(lottoStatistics);
    }
}

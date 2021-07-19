package lotto.controller;

import lotto.domain.dto.LottoResult;
import lotto.domain.dto.PurchaseInput;
import lotto.domain.dto.PurchaseResult;
import lotto.domain.dto.WinningLottoInput;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public PurchaseResult purchase(PurchaseInput purchaseInput) throws IllegalArgumentException {
        return lottoService.purchase(purchaseInput);
    }

    public LottoResult calculateResult(PurchaseResult purchaseResult, WinningLottoInput winningLottoInput) throws IllegalArgumentException {
        return lottoService.calculateResult(purchaseResult, winningLottoInput);
    }
}

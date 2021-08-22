package lotto.domain;

import lombok.Getter;
import lotto.domain.dto.ManualPurchaseCountDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.util.NumberValidateUtils;

public class PurchaseCount {

    @Getter
    private final int purchaseCount;

    public PurchaseCount(String input) {
        input = input.trim();
        validate(input);
        this.purchaseCount = Integer.parseInt(input) / Lotto.PRICE;
    }

    public PurchaseCount(PurchasePriceInputDTO purchasePriceInputDTO, ManualPurchaseCountDTO manualPurchaseCountDTO) {
        this("" + (Integer.parseInt(purchasePriceInputDTO.getInput()) - Integer.parseInt(manualPurchaseCountDTO.getInput()) * Lotto.PRICE));
    }

    private void validate(String input) {
        int inputConversion = NumberValidateUtils.parseLottoNumber(input);
        if (notMatchesCondition(inputConversion)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input % Lotto.PRICE != 0;
    }
}

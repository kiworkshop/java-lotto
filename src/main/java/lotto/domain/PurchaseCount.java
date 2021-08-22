package lotto.domain;

import lombok.Getter;
import lotto.domain.dto.ManualPurchaseCountDTO;
import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.util.NumberValidateUtils;

public class PurchaseCount {

    @Getter
    private final int randomLottoPurchaseCount;

    public PurchaseCount(String input) {
        input = input.trim();
        validate(input);
        this.randomLottoPurchaseCount = Integer.parseInt(input) / Lotto.PRICE;
    }

    public PurchaseCount(PurchasePriceInputDTO purchasePriceInputDTO, ManualPurchaseCountDTO manualPurchaseCountDTO) {
        int randomPurchasePrice = Integer.parseInt(purchasePriceInputDTO.getInput()) - Integer.parseInt(manualPurchaseCountDTO.getInput()) * Lotto.PRICE;
        checkMultiplyOfUnitPrice(randomPurchasePrice);
        this.randomLottoPurchaseCount = randomPurchasePrice / Lotto.PRICE;
    }

    private void validate(String input) {
        int inputConversion = NumberValidateUtils.parseLottoNumber(input);
        checkMultiplyOfUnitPrice(inputConversion);
    }

    private void checkMultiplyOfUnitPrice(int input) {
        if (notMatchesCondition(input)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input % Lotto.PRICE != 0;
    }
}

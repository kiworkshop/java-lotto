package lotto.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class PurchasePriceInputDTO {

    public static final int MINIMUM_PURCHASE_INPUT = 1000;
    private final String input;

    public PurchasePriceInputDTO(String input) {
        if(Integer.parseInt(input) < MINIMUM_PURCHASE_INPUT) {
            throw new IllegalArgumentException("최소 구입금액은 1000원 입니다.");
        }
        this.input = input;
    }
}

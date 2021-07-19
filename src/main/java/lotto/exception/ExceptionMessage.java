package lotto.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lotto.domain.Lotto;

@RequiredArgsConstructor
public enum ExceptionMessage {

    NON_NUMBER_INPUT("숫자를 입력해주세요."),
    LESS_THAN_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY("구입금액은 " + Lotto.PRICE + " 이상의 값을 입력해주세요."),
    NON_MULTIPLE_OF_LOTTO_PRICE_INPUT_FOR_PURCHASE_MONEY("구입금액은 " + Lotto.PRICE + "의 배수로 입력해주세요."),
    INVALID_LENGTH_INPUT_FOR_LOTTO("로또 번호는 6개를 입력해주세요"),
    DUPLICATE_LOTTO_NUMBER_INPUT_FOR_LOTTO("로또 번호는 중복되지 않는 6개의 숫자를 입력해주세요"),
    OUT_OF_BOUND_INPUT_FOR_LOTTO_NUMBER("로또 번호는 1 이상 45 이하의 값을 입력해주세요.");

    @Getter
    private final String message;
}

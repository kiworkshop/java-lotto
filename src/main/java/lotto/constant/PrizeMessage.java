package lotto.constant;

import lombok.Getter;

public enum PrizeMessage {
    FIRST("6개 일치 (2000000000원)- "),
    SECOND("5개 일치, 보너스 볼 일치(30000000원) - "),
    THIRD("5개 일치 (1500000원)- "),
    FOURTH("4개 일치 (50000원)- "),
    FIFTH("3개 일치 (5000원)- ");

    @Getter
    private final String message;

    PrizeMessage(String message) {
        this.message= message;
    }
}

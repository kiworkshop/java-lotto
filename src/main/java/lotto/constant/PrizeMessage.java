package lotto.constant;

import lombok.Getter;

public enum PrizeMessage {
    FIRST(PrizeCondition.FIRST.getMatchNumbersCount() + "개 일치 (" + PrizeMoney.FIRST.getValue() + "원)- "),
    SECOND(PrizeCondition.SECOND.getMatchNumbersCount() + "개 일치, 보너스 볼 일치(" + PrizeMoney.SECOND.getValue() + "원) - "),
    THIRD(PrizeCondition.THIRD.getMatchNumbersCount() + "개 일치 (" + PrizeMoney.THIRD.getValue() + "원)- "),
    FOURTH(PrizeCondition.FOURTH.getMatchNumbersCount() + "개 일치 (" + PrizeMoney.FOURTH.getValue() + "원)- "),
    FIFTH(PrizeCondition.FIFTH.getMatchNumbersCount() + "개 일치 (" + PrizeMoney.FIFTH.getValue() + "원)- ");

    @Getter
    private final String message;

    PrizeMessage(String message) {
        this.message= message;
    }
}

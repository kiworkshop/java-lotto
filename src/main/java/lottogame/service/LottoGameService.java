package lottogame.service;

import lottogame.domain.MoneyAmount;

public class LottoGameService {

    public MoneyAmount getMoneyAmount(int input) {
        return new MoneyAmount(input);
    }

    public int getLottoCount(MoneyAmount moneyAmount) {
        return moneyAmount.calculateLottoCount();
    }
}

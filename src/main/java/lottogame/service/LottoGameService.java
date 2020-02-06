package lottogame.service;

import lottogame.domain.MoneyAmount;

public class LottoGameService {

    public MoneyAmount getMoneyAmount(int input) {
        return new MoneyAmount(input);
    }
}

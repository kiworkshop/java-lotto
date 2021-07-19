package lotto.view;

import java.util.List;

public interface InputView {
    Integer getPurchaseCost();

    List<Integer> getWinningLottoNumbers();

    Integer getWinningLottoBonus();
}

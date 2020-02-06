package lottogame;

import lottogame.controller.LottoGameController;
import lottogame.view.InputView;

public class LottoGameStarter {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView());
        lottoGameController.run();
    }
}

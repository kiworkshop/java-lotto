package lottogame;

import lottogame.controller.LottoGameController;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameStarter {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new InputView(), new OutputView());
        lottoGameController.run();
    }
}

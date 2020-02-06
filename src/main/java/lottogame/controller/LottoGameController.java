package lottogame.controller;

import lottogame.view.InputView;

public class LottoGameController {

    private final InputView inputView;

    public LottoGameController(InputView inputView) {
            this.inputView = inputView;
        }

        public void run() {
            int moneyAmount = inputView.getMoneyAmount();
        }
    }

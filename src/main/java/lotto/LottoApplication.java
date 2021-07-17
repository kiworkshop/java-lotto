package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.View;

public class LottoApplication {

    public static void main(String[] args) {
        View view = View.builder()
                .inputView(new ConsoleInputView())
                .outputView(new ConsoleOutputView())
                .build();
        LottoController lottoController = new LottoController(view);
        lottoController.start();
    }
}

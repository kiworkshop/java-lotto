package lotto.application;

import lotto.controller.LottoController;
import lotto.view.LottoView;
import lotto.view.View;

public class LottoApplication {
    public static void main(String[] args) {
        View view = new LottoView();
        LottoController controller = new LottoController(view);
        controller.run();
    }
}

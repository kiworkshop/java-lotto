package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoApplication {

  public static void main(String[] args) {
    LottoController controller = new LottoController();
    controller.run(new ConsoleInputView(), new ConsoleOutputView());
  }
}

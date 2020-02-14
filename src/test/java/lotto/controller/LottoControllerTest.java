package lotto.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.exception.IllegalNumberInputException;

class LottoControllerTest {
  LottoController controller = new LottoController();

  @Test
  public void 구매금액입력시_숫자가아니면_예외발생() {
    Exception exception = assertThrows(IllegalNumberInputException.class,
        () -> controller.parseStringToInt("숫자아닌문자열"));
    assertThat(exception.getMessage()).isEqualTo(IllegalNumberInputException.NUMBER_INPUT_MESSAGE);
  }

}
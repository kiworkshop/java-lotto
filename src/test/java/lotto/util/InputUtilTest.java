package lotto.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.exception.IllegalNumberInputException;

public class InputUtilTest {
  @Test
  public void 구매금액입력시_숫자가아니면_예외발생() {
    Exception exception = assertThrows(IllegalNumberInputException.class,
        () -> InputUtil.parseStringToInt("숫자아닌문자열"));
    assertThat(exception.getMessage()).isEqualTo(IllegalNumberInputException.NUMBER_INPUT_MESSAGE);
  }
}

package lotto.util;

import lotto.exception.IllegalNumberInputException;

public class InputUtil {
  public static int parseStringToInt(String numberString) {
    try {
      return Integer.parseInt(numberString);
    } catch (NumberFormatException e) {
      throw new IllegalNumberInputException();
    }
  }
}

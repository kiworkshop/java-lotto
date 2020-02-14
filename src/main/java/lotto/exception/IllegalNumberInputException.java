package lotto.exception;

public class IllegalNumberInputException extends IllegalArgumentException {
  public static final String NUMBER_INPUT_MESSAGE = "구매금액을 숫자로만 입력해주세요.";

  public IllegalNumberInputException() {
    super(NUMBER_INPUT_MESSAGE);
  }
}

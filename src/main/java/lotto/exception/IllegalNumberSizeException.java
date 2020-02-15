package lotto.exception;

public class IllegalNumberSizeException extends IllegalArgumentException {
  public static final String NUMBER_SIZE_NOT_MATCH_MESSAGE = "로또 숫자 개수는 %d개여야 합니다.";
  private int size;

  public IllegalNumberSizeException(int size) {
    super(String.format(NUMBER_SIZE_NOT_MATCH_MESSAGE, size));
  }
}

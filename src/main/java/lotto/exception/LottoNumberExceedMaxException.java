package lotto.exception;

public class LottoNumberExceedMaxException extends IllegalLottoNumberException {
  public static final String NUMBER_EXCEED_MAX_MESSAGE = "로또 숫자는 %d를 초과할 수 없습니다.";
  private int size;

  public LottoNumberExceedMaxException(int size) {
    super(String.format(NUMBER_EXCEED_MAX_MESSAGE, size));
  }
}

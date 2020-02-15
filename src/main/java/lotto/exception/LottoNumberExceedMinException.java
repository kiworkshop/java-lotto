package lotto.exception;

public class LottoNumberExceedMinException extends IllegalLottoNumberException {
  public static final String NUMBER_EXCEED_MIN_MESSAGE = "로또 숫자는 %d 미만일 수 없습니다.";
  private int size;

  public LottoNumberExceedMinException(int size) {
    super(String.format(NUMBER_EXCEED_MIN_MESSAGE, size));
  }
}

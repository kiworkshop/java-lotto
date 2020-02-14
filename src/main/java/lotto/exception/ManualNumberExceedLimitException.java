package lotto.exception;

public class ManualNumberExceedLimitException extends IllegalArgumentException {
  public static final String MANUAL_NUMBER_EXCEED_LIMIT_MESSAGE = "수동 입력 로또는 전체 로또 수를 초과할 수 없습니다.";

  public ManualNumberExceedLimitException() {
    super(MANUAL_NUMBER_EXCEED_LIMIT_MESSAGE );
  }
}

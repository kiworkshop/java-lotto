package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.exception.IllegalNumberSizeException;
import lotto.exception.LottoNumberExceedMaxException;
import lotto.exception.LottoNumberExceedMinException;

public class LottoTicketTest {

  @Test
  public void LottoTicket생성시_숫자개수가_6개를_넘으면_예외발생() {
    // given
    List<String> lottoInputs = new ArrayList<>();
    lottoInputs.add("1");
    lottoInputs.add("2");
    lottoInputs.add("3");
    lottoInputs.add("4");
    lottoInputs.add("5");
    lottoInputs.add("6");
    lottoInputs.add("7");

    assertThrows(IllegalNumberSizeException.class, () -> LottoTicket.of(lottoInputs));
  }

  @Test
  public void LottoTicket의_각_숫자가_MAX_NUMBER_를_넘으면_예외발생() {
    // given
    List<String> lottoInputs = new ArrayList<>();
    lottoInputs.add("1");
    lottoInputs.add("2");
    lottoInputs.add("3");
    lottoInputs.add("4");
    lottoInputs.add("5");
    lottoInputs.add("46");

    assertThrows(LottoNumberExceedMaxException.class, () -> LottoTicket.of(lottoInputs));
  }

  @Test
  public void LottoTicket의_각_숫자가_MIN_NUMBER_이하이면_예외발생() {
    // given
    List<String> lottoInputs = new ArrayList<>();
    lottoInputs.add("0");
    lottoInputs.add("-1");
    lottoInputs.add("3");
    lottoInputs.add("4");
    lottoInputs.add("5");
    lottoInputs.add("6");

    assertThrows(LottoNumberExceedMinException.class, () -> LottoTicket.of(lottoInputs));
  }
}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.strategy.RandomNumberStrategy;
import lotto.strategy.NumberStrategy;

public class LottoTicket {
  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final int LOTTO_MAX_NUMBER = 45;
  private List<Integer> lottoNumbers = new ArrayList<>();

  private LottoTicket() {
    lottoNumbers.addAll(generateLottoNumbers(new RandomNumberStrategy()));
  }

  public static LottoTicket of() {
    return new LottoTicket();
  }

  protected List<Integer> generateLottoNumbers(NumberStrategy numberStrategy) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < LOTTO_NUMBERS_SIZE; i++) {
      numbers.add(numberStrategy.generateNumber(LOTTO_MAX_NUMBER));
    }
    return numbers;
  }

}

package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.strategy.RandomNumberStrategy;
import lotto.strategy.NumberStrategy;

public class LottoTicket {
  private static final int LOTTO_NUMBERS_SIZE = 6;
  private static final int LOTTO_MAX_NUMBER = 45;
  private List<Integer> lottoNumbers = new ArrayList<>();

  private LottoTicket(NumberStrategy numberStrategy) {
    lottoNumbers.addAll(generateLottoNumbers(numberStrategy));
  }

  public static LottoTicket ofRandom() {
    return new LottoTicket(new RandomNumberStrategy());
  }

  protected List<Integer> generateLottoNumbers(NumberStrategy numberStrategy) {
    return numberStrategy.generateNumbers(LOTTO_NUMBERS_SIZE, LOTTO_MAX_NUMBER);
  }

  public void showLottoNumbers() {
    System.out.println(lottoNumbers.toArray().toString());
  }

  public int calculateNumOfMatch(List<Integer> winningNumbers) {
    return (int) lottoNumbers.stream()
        .filter(winningNumbers::contains)
        .count();
  }

}

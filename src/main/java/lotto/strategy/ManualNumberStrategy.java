package lotto.strategy;

import java.util.List;

import lotto.exception.IllegalNumberSizeException;
import lotto.exception.LottoNumberExceedMaxException;
import lotto.exception.LottoNumberExceedMinException;

public class ManualNumberStrategy implements NumberStrategy {
  private List<Integer> ticketInputs;

  public ManualNumberStrategy(List<Integer> ticketInputs) {
    this.ticketInputs = ticketInputs;
  }

  public List<Integer> generateNumbers(int numbersSize, int minNumber, int maxNumber) {
    validateNumbersSize(numbersSize);
    validateLimits(minNumber, maxNumber);
    return ticketInputs;
  }

  private void validateNumbersSize(int size) {
    if (ticketInputs.size() != size) {
      throw new IllegalNumberSizeException(size);
    }
  }

  private void validateLimits(int min, int max) {
    for (Integer ticketInput : ticketInputs) {
      if (ticketInput > max) {
        throw new LottoNumberExceedMaxException(max);
      }
      if (ticketInput < min) {
        throw new LottoNumberExceedMinException(min);
      }
    }
  }
}

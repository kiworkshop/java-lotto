package lotto.strategy;

import java.util.List;

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

  // TODO: 2020-02-15 create each exception
  private void validateNumbersSize(int size) {
    if (ticketInputs.size() != size) {
      throw new IllegalArgumentException();
    }
  }

  private void validateLimits(int min, int max) {
    for (Integer ticketInput : ticketInputs) {
      if (ticketInput > max) {
        throw new IllegalArgumentException();
      }
      if (ticketInput < min) {
        throw new IllegalArgumentException();
      }
    }
  }
}

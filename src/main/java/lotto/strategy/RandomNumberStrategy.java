package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {

  public List<Integer> generateNumbers(int numbersSize, int maxNumber) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < numbersSize; i++) {
      numbers.add(generateNumber(maxNumber));
    }
    return numbers;
  }

  private int generateNumber(int maxNumber) {
    return new Random().nextInt(maxNumber + 1);
  }

}

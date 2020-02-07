package lotto.strategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberStrategy {

  public int generateNumber(int maxNumber) {
    return new Random().nextInt(maxNumber + 1);
  }
}

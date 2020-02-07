package lotto.strategy;

import java.util.List;

public interface NumberStrategy {
  List<Integer> generateNumbers(int numbersSize, int maxNumber);
}

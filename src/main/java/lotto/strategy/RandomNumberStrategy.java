package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberStrategy implements NumberStrategy {

  public List<Integer> generateNumbers(int numbersSize, int minNumber, int maxNumber) {
    List<Integer> numbers = IntStream.rangeClosed(minNumber, maxNumber)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);
    return numbers.stream()
        .limit(numbersSize)
        .sorted()
        .collect(Collectors.toList());
  }
}

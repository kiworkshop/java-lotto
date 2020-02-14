package lotto.strategy;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RandomNumberStrategyTest {

  private NumberStrategy numberStrategy = new RandomNumberStrategy();

  @Test
  public void 생성되는_숫자리스트는_중복이_없어야_한다() {
    List<Integer> numbers = numberStrategy.generateNumbers(6, 1, 45);
    Set<Integer> numbersDuplicationRemoved = new HashSet<>(numbers);

    assertThat(numbers.size()).isEqualTo(numbersDuplicationRemoved.size());
  }

  @Test
  public void 생성되는_숫자리스트는_오름차순_정렬되어있어야_한다() {
    List<Integer> numbers = numberStrategy.generateNumbers(6, 1, 45);

    for (int i = 0; i < numbers.size() - 1; i++) {
      assertThat(numbers.get(i)).isLessThan(numbers.get(i + 1));
    }
  }
}

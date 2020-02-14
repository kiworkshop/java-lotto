import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;
    static WinningNumbers of(List<Integer> numbers, int bonusNumber) {

        return new WinningNumbers(numbers, bonusNumber);
    }

    WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validateWinningNumbers(numbers, bonusNumber);
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> numbers, int bonusNumber) {
        numbers.add(bonusNumber);
        Set<Integer> numbersWithoutDuplication =  new HashSet<>(numbers);
        if (numbersWithoutDuplication.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbersWithoutDuplication.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException();
        }
    }
}

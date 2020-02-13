import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;
    public static WinningNumbers of(List<Integer> numbers, int bonusNumber) {

        return new WinningNumbers(numbers, bonusNumber);
    }

    WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}

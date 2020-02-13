import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(List<Integer> numbers, int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

}

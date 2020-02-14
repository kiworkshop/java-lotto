import java.util.*;

public class Lotto {
    private static final int NUMBER_OF_BALLS = 45;
    private static final int RAFFLE_FROM_INDEX = 0;
    private static final int RAFFLE_TO_INDEX = 6;
    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateLottoNumbers(numbers);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplication =  new HashSet<>(numbers);
        if (numbersWithoutDuplication.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbersWithoutDuplication.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException();
        }
    }

    static Lotto autoGenerate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_BALLS; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = numbers.subList(RAFFLE_FROM_INDEX, RAFFLE_TO_INDEX);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }

    public static Lotto manualGenerate(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    List<Integer> getNumbers() {
        return numbers;
    }

}

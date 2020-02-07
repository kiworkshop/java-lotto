import java.util.*;

public class Lotto {
    private static final int NUMBER_OF_BALLS = 45;
    private static final int RAFFLE_FROM_INDEX = 0;
    private static final int RAFFLE_TO_INDEX = 6;
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;    //TODO 숫자 검증 추가
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

    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public int checkHits(List<Integer> winningNumbers) {
        List<Integer> addedNumbers = new ArrayList<>();    //TODO  contains를 쓰며 indent를 지키는 방법이 궁금
        addedNumbers.addAll(numbers);
        addedNumbers.addAll(winningNumbers);

        return addedNumbers.size() - new HashSet<Integer>(addedNumbers).size();
    }
}

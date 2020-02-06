import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;    //TODO 숫자 검증 추가
    }

    public static Lotto autoGenerate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> generatedNumbers = numbers.subList(0, 6);
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

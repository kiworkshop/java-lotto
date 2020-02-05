import com.sun.management.GarbageCollectionNotificationInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> generatedNumbers = numbers.subList(0,6);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }

    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}

package lotto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        String[] chunks = input.split(",");
        winningNumbers = Arrays.stream(chunks)
                .map(String::trim)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}

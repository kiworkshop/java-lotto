package lotto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class WinningNumbers {

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(String input) {
        String[] chunks = input.split(",");
        winningNumbers = Arrays.stream(chunks)
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

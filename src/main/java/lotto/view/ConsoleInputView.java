package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    private static final String LOTTO_NUMBERS_INPUT_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public Integer getPurchaseCost() throws NumberFormatException {
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningLottoNumbers() throws NumberFormatException {
        String input = scanner.nextLine();
        return Arrays.stream(input.split(LOTTO_NUMBERS_INPUT_DELIMITER))
                .map(String::trim)
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    public Integer getWinningLottoBonus() throws NumberFormatException {
        String input = scanner.nextLine().trim();
        return Integer.parseInt(input);
    }
}

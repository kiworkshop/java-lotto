package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {
    private static final String COMMA = ",";

    private static final int LOTTO_LENGTH = 6;
    private static final String ALERT_CHECK_COMMA = String.format("구분자를 \"%s\"로 입력하셨는지 확인해주세요.", COMMA);
    private static final String ALERT_CHECK_NULL_OR_EMPTY = String.format("\"%s\"로 구분한 지난 주 당첨번호를 입력해주세요.", COMMA);

    private static final String ALERT_CHECK_LENGTH = String.format("당첨번호는 %d개 이어야 합니다.", LOTTO_LENGTH);
    private static final String ALERT_CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private static final String ALERT_CHECK_BONUS_DUPLICATE = "보너스볼이 당첨 번호와 중복되는지 확인해주세요.";

    public boolean checkGivenMoney(String givenMoney) {
        try {
            Integer.parseInt(givenMoney);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int checkBonusBall(String bonusInput, List<Integer> winningNumber) {
        int bonusInputNumber = Integer.parseInt(bonusInput);
        checkBonusDuplicate(bonusInputNumber, winningNumber);
        return bonusInputNumber;
    }


    private static List<Integer> toIntegers(List<String> input) {
        return new ArrayList<>(Collections.unmodifiableList(input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList())));
    }

    private static List<String> splitByComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ALERT_CHECK_COMMA);
        }
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void checkNullOrEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ALERT_CHECK_NULL_OR_EMPTY);
        }
    }

    public List<Integer> checkWinningNumbers(String winningNumber) {
        checkNullOrEmpty(winningNumber);
        List<Integer> winningNumbers = toIntegers(splitByComma(winningNumber));
        validate(winningNumbers);
        return winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        checkLength(winningNumbers);
        checkDuplicate(winningNumbers);
    }

    private void checkLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ALERT_CHECK_LENGTH);

        }
    }

    private void checkDuplicate(List<Integer> winningNumbers) {
        int countOfDeDuplication = (int) winningNumbers.stream()
                .distinct()
                .count();

        if (countOfDeDuplication != winningNumbers.size()) {
            throw new IllegalArgumentException(ALERT_CHECK_DUPLICATION);
        }
    }

    private void checkBonusDuplicate(int bonusInputNumber, List<Integer> winningNumber) {
        boolean isDuplicate = winningNumber.stream()
                .anyMatch(number -> bonusInputNumber == number);

        if (isDuplicate) {
            throw new IllegalArgumentException(ALERT_CHECK_BONUS_DUPLICATE);
        }
    }
}

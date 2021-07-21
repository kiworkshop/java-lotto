package com.study.domain;

import java.util.List;
import java.util.regex.Pattern;

public class LottoValication {

    public static final int LOTTO_PRICE = 1000;
    public static final int BOUND_MIN = 1;
    public static final int BOUND_MAX = 45;
    public static final int LOTTO_LENGTH = 6;

    private static final String LOTTO_PRICE_PATTERN = "\\d*000";
    private static final String ALERT_CHECK_BOUND = String.format("당첨번호는 %d - %d 사이값을 입력해주세요", BOUND_MIN, BOUND_MAX);
    private static final String ALERT_CHECK_LENGTH = String.format("당첨번호는 %d개 이어야 합니다.", LOTTO_LENGTH);
    private static final String ALERT_CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private static final String ALERT_CHECK_BONUS_DUPLICATE = "보너스볼이 당첨 번호와 중복되는지 확인해주세요.";
    private static final String ALERT_CHECK_PAYMENT_MANUAL= "구매 금액 이상의 수동 로또를 살 수 없습니다.";
    private static final String ALERT_CHECK_PAYMENT= "1000원 단위의 금액만 투입할 수 있습니다.";

    public int checkGivenMoney(String givenMoney) {
        if (!Pattern.matches(LOTTO_PRICE_PATTERN, givenMoney)) {
            throw new IllegalArgumentException(ALERT_CHECK_PAYMENT);
        }
        return Integer.parseInt(givenMoney);
    }

    public void lottoNumberValidate(List<Integer> winningNumbers) {
        checkListBound(winningNumbers);
        checkLength(winningNumbers);
        checkDuplicate(winningNumbers);
    }

    public void checkBound(int number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(ALERT_CHECK_BOUND);
        }
    }

    public void checkBonusDuplicate(int bonusInputNumber, List<Integer> winningNumber) {
        boolean isDuplicate = winningNumber.stream()
                .anyMatch(number -> bonusInputNumber == number);

        if (isDuplicate) {
            throw new IllegalArgumentException(ALERT_CHECK_BONUS_DUPLICATE);
        }
    }

    private void checkListBound(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            checkBound(winningNumber);
        }
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

    public void canbyAllTickets(int totalCount, int manulCount) {
        if(totalCount<manulCount) {
            throw new IllegalArgumentException(ALERT_CHECK_PAYMENT_MANUAL);
        }
    }
}

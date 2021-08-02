package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String BUYING_PRICE_MESSAGE = "\n구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getBuyingPrice() {
        System.out.println(BUYING_PRICE_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String getManualCount() {
        System.out.println(MANUAL_COUNT_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static List<String> getManualNumbers(int manualTicketAmount) {
        if (manualTicketAmount == 0) {
            return Collections.emptyList();
        }
        System.out.println(MANUAL_NUMBER_MESSAGE);
        return IntStream.range(0, manualTicketAmount)
                .mapToObj(i -> scanner.nextLine().trim())
                .collect(Collectors.toList());
    }

    public static String getWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static String getBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextLine().trim();
    }
}

package lotto.view;

import lotto.domain.vending.TicketAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String BUYING_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

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

    public static List<String> getManualNumbers(TicketAmount ticketAmount) {
        System.out.println(MANUAL_NUMBER_MESSAGE);
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < ticketAmount.manual(); i++) {
            manualNumbers.add(scanner.nextLine().trim());
        }
        return manualNumbers;
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

package lottogame.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_GET_MONEY_AMOUNT = "구입금액을 입력해 주세요.";

    public int getMoneyAmount() {
        System.out.println(MESSAGE_GET_MONEY_AMOUNT);
        return SCANNER.nextInt();
    }
}

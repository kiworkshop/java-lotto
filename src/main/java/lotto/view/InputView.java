package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().trim();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine().trim();
    }
}

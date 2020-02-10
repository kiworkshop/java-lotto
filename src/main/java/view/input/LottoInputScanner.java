package view.input;

import java.util.Scanner;

public class LottoInputScanner {

    private static final String PURCHASE_LOTTO_PRICE_STATEMENT = "구입 금액을 입력해주세요.";
    private static final String ASK_LAST_LOTTERY_NUMBER_STATEMENT = "지난주 당첨 번호를 입력해주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해주세요";
    private static final Scanner inputScanner = new Scanner(System.in);

    public static String askLottoPurchacePrice() {
        System.out.println(PURCHASE_LOTTO_PRICE_STATEMENT);
        return inputScanner.nextLine();
    }

    public static String askLottoWinningNumber() {
        System.out.println(ASK_LAST_LOTTERY_NUMBER_STATEMENT);
        return inputScanner.nextLine();
    }

    public static String askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return inputScanner.nextLine();
    }
}

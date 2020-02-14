package lottogame.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_GET_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_GET_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_GET_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_GET_LOTTO_RESULT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_GET_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    public int getMoneyAmountInput() {
        System.out.println(MESSAGE_GET_MONEY_AMOUNT);

        return SCANNER.nextInt();
    }

    public int getManualLottoCount() {
        System.out.println(MESSAGE_GET_MANUAL_LOTTO_COUNT);

        return SCANNER.nextInt();
    }

    public String[] getManualLottoNumbers(int manualLottoCount) {
        SCANNER.nextLine(); // 개행문자(엔터) 처리

        System.out.println(MESSAGE_GET_MANUAL_LOTTO_NUMBERS);

        String[] inputs = new String[manualLottoCount];
        for (int i = 0; i < manualLottoCount; i++) {
            String input = SCANNER.nextLine();
            inputs[i] = input;
        }
        return inputs;
    }

    public String getLottoResultInput() {
        System.out.println();
        System.out.println(MESSAGE_GET_LOTTO_RESULT);

        return SCANNER.nextLine();
    }

    public int getBonusNumber() {
        System.out.println(MESSAGE_GET_BONUS_BALL);

        return SCANNER.nextInt();
    }
}

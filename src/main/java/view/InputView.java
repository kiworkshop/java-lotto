package view;

import utils.PreConditionUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            String givenMoney = scanner.nextLine().trim();
            PreConditionUtil.checkNullOrEmpty(givenMoney);
            return Integer.parseInt(givenMoney);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("구입금액은 숫자만 입력할 수 있습니다. 다시 입력해주세요.");
            return inputMoney();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String winningNumbersInput = scanner.nextLine();
        PreConditionUtil.checkNullOrEmpty(winningNumbersInput);

        return PreConditionUtil.toIntegers(PreConditionUtil.splitByComma(winningNumbersInput));
    }

    public int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");

        String bonusInput = scanner.nextLine();
        PreConditionUtil.checkNullOrEmpty(bonusInput);
        return Integer.parseInt(bonusInput);
    }

}

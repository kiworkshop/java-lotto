package view;

import utils.InputValidation;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static InputValidation inputValidation = new InputValidation();

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputValidation.checkGivenMoney(scanner.nextLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputValidation.checkWinningNumbers(scanner.nextLine());
    }

    public int inputBonusBall(List<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputValidation.checkBonusBall(scanner.nextLine(), winningNumbers);
    }

}

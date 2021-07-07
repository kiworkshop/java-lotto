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

}

package com.study.view;

import com.study.utils.InputValidation;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static InputValidation inputValidation = new InputValidation();

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        inputValidation.checkNullOrEmpty(money);
        return  money;
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();
        inputValidation.checkNullOrEmpty(winningNumber);
        return winningNumber;
    }

    public String inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}

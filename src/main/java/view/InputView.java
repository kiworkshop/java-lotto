package view;

import utils.InputValication;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static InputValication inputValication = new InputValication();
    public int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return inputValication.checkGivenMoeny(scanner.nextLine());
    }

}

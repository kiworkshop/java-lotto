package com.study.view;

import com.study.utils.InputValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final InputValidation INPUT_VALICATION = new InputValidation();

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        INPUT_VALICATION.checkNullOrEmpty(money);
        return money;
    }

    public int manualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manulTicketCount = scanner.nextLine();
        INPUT_VALICATION.checkNullOrEmpty(manulTicketCount);
        return Integer.parseInt(manulTicketCount);
    }

    public List<List<Integer>> manualLottlNumbers(int manulTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < manulTicketCount; i++) {
            List<Integer> lottoNumbers = manualLottlNumber();
            lottos.add(lottoNumbers);
        }
        return lottos;
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();
        INPUT_VALICATION.checkNullOrEmpty(winningNumber);
        return winningNumber;
    }

    public String inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    private List<Integer> manualLottlNumber() {
        String manulTicketCount = INPUT_VALICATION.removeBlank(scanner.nextLine());
        INPUT_VALICATION.checkNullOrEmpty(manulTicketCount);
        List<String> manulLottoNumbers = InputValidation.splitByComma(manulTicketCount);
        return InputValidation.toIntegers(manulLottoNumbers);
    }

}

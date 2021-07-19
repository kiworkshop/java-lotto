package lotto.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String getPurchaseCost() {
        return scanner.nextLine();
    }

    public String getWinningLottoNumbers() {
        return scanner.nextLine();
    }

    public String getWinningLottoBonus() {
        return scanner.nextLine();
    }
}

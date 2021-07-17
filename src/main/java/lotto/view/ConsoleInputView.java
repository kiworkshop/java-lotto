package lotto.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    private String nextLine() {
        return scanner.nextLine();
    }

    public String getPurchaseCost() {
        return nextLine();
    }

    public String getWinningLottoNumbers() {
        return nextLine();
    }

    public String getWinningLottoBonus() {
        return nextLine();
    }
}

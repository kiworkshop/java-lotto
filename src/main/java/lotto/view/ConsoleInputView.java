package lotto.view;

import java.util.Scanner;

public class ConsoleInputView {
  private final Scanner scan = new Scanner(System.in);

  public int getPriceInput() {
    System.out.println("구매금액을 입력해주세요.");
    return Integer.parseInt(scan.nextLine());
  }

  public String getWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scan.nextLine();
  }
}

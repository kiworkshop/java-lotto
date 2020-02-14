package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
  private final Scanner scan = new Scanner(System.in);

  public String getPriceInput() {
    System.out.println("구매금액을 입력해주세요.");
    return scan.nextLine();
  }

  public String getNumOfManualLotto() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return scan.nextLine();
  }

  public List<String> getManualLottoNumbers(int numOfManualTickets) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> tickets = new ArrayList<>();
    for (int i = 0; i < numOfManualTickets; i++) {
      tickets.add(scan.nextLine());
    }
    return tickets;
  }

  public String getWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scan.nextLine();
  }

  public String getBonusBallNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return scan.nextLine();
  }
}

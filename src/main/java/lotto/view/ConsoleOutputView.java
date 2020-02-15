package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Prizes;

public class ConsoleOutputView {

  public void showLottoTickets(LottoTickets manualTickets, LottoTickets randomTickets) {
    System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
        manualTickets.size(), randomTickets.size()));
    manualTickets.show();
    randomTickets.show();
  }

  public void showResult(Prizes prizes) {
    System.out.println("당첨 통계");
    System.out.println("-------------");
    prizes.showStat();
    System.out.println("총 수익률은 " + prizes.getEarningRate() + "% 입니다.");
  }
}

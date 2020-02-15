package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Prizes;

public class ConsoleOutputView {
  private static final String STATISTIC_HEADER = "당첨 통계";
  private static final String DELIMIT_LINE = "-------------";
  private static final String ERROR_HEADER = "ERROR: ";

  public void showLottoTickets(LottoTickets manualTickets, LottoTickets randomTickets) {
    System.out.println(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.",
        manualTickets.size(), randomTickets.size()));
    manualTickets.show();
    randomTickets.show();
  }

  public void showResult(Prizes prizes) {
    System.out.println(STATISTIC_HEADER);
    System.out.println(DELIMIT_LINE);
    prizes.showStat();
    System.out.println(String.format("총 수익률은 %d 입니다", prizes.getEarningRate()));
  }

  public void showExceptionMessage(Exception e) {
    System.out.println(ERROR_HEADER + e.getMessage());
  }
}

package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Prizes;

public class ConsoleOutputView {

  public void showLottoTickets(LottoTickets lottoTickets) {
    System.out.println(lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
    lottoTickets.show();
  }

  public void showResult(Prizes prizes) {
    System.out.println("당첨 통계");
    System.out.println("-------------");
    prizes.showStat();
    System.out.println("총 수익률은 " + prizes.getEarningRate() + "% 입니다.");
  }
}

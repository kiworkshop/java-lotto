package lotto.view;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.Prizes;

public class ConsoleOutputView {

  public void showLottoTickets(List<LottoTicket> lottoTickets) {
    System.out.println(lottoTickets.size() + "개를 구매했습니다.");
    for (LottoTicket lottoTicket : lottoTickets) {
      lottoTicket.showLottoNumbers();
    }
  }

  public void showResult(Prizes prizes) {
    System.out.println("당첨 통계");
    System.out.println("-------------");
    prizes.showStat();
    System.out.println("총 수익률은 " + prizes.getEarningRate() + "% 입니다.");
  }
}

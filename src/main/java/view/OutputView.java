package view;

import domain.Lotto;
import enums.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(getLottoNumberString(lottoTicket.getLottoNumbers()));
        }
    }

    public void printStatistics(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.\n", profitRate);
    }

    public void printRankResult(Map<Rank, Integer> rankResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        rankResult.forEach(this::result);
    }

    private void result(Rank rank, int count) {
        if (rank != Rank.ETC)
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.matched(), rank.prize(), count);
        if (rank == Rank.SECOND_PLACE)
            System.out.printf("%d개 일치, 보너스볼 일치 (%d원)- %d개\n", rank.matched(), rank.prize(), count);
    }

    private String getLottoNumberString(List<Integer> lottoNumbers) {
        String lottoString = "[";
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            lottoString = lottoString + lottoNumbers.get(i) + ", ";
        }
        lottoString = lottoString + lottoNumbers.get(lottoNumbers.size() - 1) + "]";
        return lottoString;
    }
}
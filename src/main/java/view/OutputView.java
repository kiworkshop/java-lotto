package view;

import domain.Lotto;
import enums.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumberString());
        }
    }


    //    당첨 통계
//---------
//        3개 일치 (5000원)- 1개
//4개 일치 (50000원)- 0개
//5개 일치 (1500000원)- 0개
//5개 일치, 보너스 볼 일치(30000000원) - 0개
//6개 일치 (2000000000원)- 0개
//    총 수익률은 0.35입니다. // 기준이 1이기 때문에 결과적으로 손해라는 의미

    public void printStatistics(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.\n", profitRate);
    }

    public void printRankResult(Map<Rank, Integer> rankResult) {
        rankResult.forEach((rank, count) -> {
            result(rank, count);
        });
    }

    private void result(Rank rank, int count) {
        if (rank != Rank.ETC) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.matched(), rank.prize(), count);
        }
        if (rank == Rank.SECOND_PLACE) {
            System.out.printf("%d개 일치, 보너스볼 일치 (%d원)- %d개\n", rank.matched(), rank.prize(), count);
        }
    }
}
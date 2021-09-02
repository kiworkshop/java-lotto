package view;

import domain.LottoResult;
import domain.LottoTicket;
import enums.Rank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoTicketString());
        }
    }

    public void printStatistics(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.\n", profitRate);
    }

    public void printLottoResult2(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> rankResult = lottoResult.getLottoResult();

        List<Rank> keyList = new ArrayList<>(rankResult.keySet());
        keyList.sort(Comparator.comparingLong(Rank::getPrize));
        for (Rank rank : keyList) {
            result(rank, rankResult.get(rank));
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<Rank, Integer> rankResult = lottoResult.getLottoResult();
        rankResult.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Rank::getPrize)))
                .forEach(rankResultEntry -> result(rankResultEntry.getKey(), rankResultEntry.getValue()));
    }

    public void result(Rank rank, int count) {
        if (!rank.isSecondPlace(rank)) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getMatched(), rank.getPrize(), count);
        }
        if (rank.isSecondPlace(rank)) {
            System.out.printf("%d개 일치, 보너스볼 일치 (%d원)- %d개\n", rank.getMatched(), rank.getPrize(), count);
        }
    }
}
package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            List<String> lottoNumbers = lottoNumberToString(lottoTicket);
            System.out.println("[" + String.join(",", lottoNumbers) + "]");
        }
    }

    private static List<String> lottoNumberToString(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(Collectors.toList());
    }

    public static void printTicketAmount(int ticketAmount) {
        System.out.printf("%s개를 구매했습니다.%n", ticketAmount);
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.%n", profitRate);
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> ranks) {
        System.out.println("당첨 통계\n---------");
        for (LottoRank rank : ranks.keySet()) {
            if ((rank.getHitCount() == 5 ) && (rank.getHitBonus() == 1)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n", rank.getHitCount(),
                        rank.getPrizeMoney(), ranks.get(rank));
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getHitCount(),
                    rank.getPrizeMoney(), ranks.get(rank));
        }
    }
}

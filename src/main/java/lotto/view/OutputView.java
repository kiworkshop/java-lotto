package lotto.view;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningLottoRank;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.values()) {
            List<String> lottoNumbers = lottoNumberToString(lottoTicket);
            System.out.println("[" + String.join(",", lottoNumbers) + "]");
        }
    }

    private static List<String> lottoNumberToString(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.value()))
                .collect(Collectors.toList());
    }

    public static void printTicketAmount(TicketAmount ticketAmount) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.%n", ticketAmount.manual(), ticketAmount.auto());
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.%n", profitRate);
    }

    public static void printWinningStatistics(WinningLottoRank winningLottoRank) {
        System.out.println("당첨 통계\n---------");
        for (LottoRank rank : winningLottoRank.keys()) {
            String message = (rank == LottoRank.SECOND) ? "%d개 일치, 보너스 볼 일치 (%d원) - %d개%n"
                                                        : "%d개 일치 (%d원) - %d개%n";
            System.out.printf(message, rank.hitCount(), rank.prizeMoney(), winningLottoRank.count(rank));
        }
    }
}

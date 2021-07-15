package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.NumberOfTickets;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNumberOfTickets(final NumberOfTickets numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets.getNumberOfTickets());
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.list()
                .stream()
                .map(LottoTicket::getLottoNumbers)
                .forEach(OutputView::printLottoTicket);
        System.out.println();
    }

    private static void printLottoTicket(final List<LottoNumber> lottoNumbers) {
        System.out.println();

        String result = lottoNumbers.stream()
                .mapToInt(LottoNumber::value)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.printf("[" + "%s" + "]", result);
    }

    public static void printWinningStatistics(final Map<LottoRank, Integer> ranksCount, final float profit) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        ranksCount.entrySet()
                .forEach(OutputView::printWinningStatistic);

        System.out.printf("총 수익률은 %.2f입니다.", profit);
    }

    private static void printWinningStatistic(final Map.Entry<LottoRank, Integer> rank) {
        if (rank.getKey().equals(LottoRank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개 \n", rank.getKey().getMatchedCount(), rank.getKey().getPrize(), rank.getValue());
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getKey().getMatchedCount(), rank.getKey().getPrize(), rank.getValue());
    }
}

package view;

import domain.LottoNumber;
import domain.LottoResult;
import domain.LottoTicket;
import enums.Rank;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static domain.LottoTicket.LOTTO_NUMBERS_SIZE;

public class OutputView {
    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoTickets.size())
                .append("개를 구매했습니다.\n");

        for (LottoTicket lottoTicket : lottoTickets) {
            sb.append(getLottoTicketString(lottoTicket))
                    .append("\n");
        }
        System.out.println(sb);
    }

    public String getLottoTicketString(LottoTicket lottoTicket) {
        List<LottoNumber> numbers = lottoTicket.getLottoTicketNumbers();
        String LotteryTicket = "[";
        for (int i = 0; i < LOTTO_NUMBERS_SIZE - 1; i++) {
            LotteryTicket = LotteryTicket + numbers.get(i) + ", ";
        }
        LotteryTicket = LotteryTicket + numbers.get(LOTTO_NUMBERS_SIZE - 1) + "]";
        return LotteryTicket;
    }

    public void printStatistics(double profitRate) {
        System.out.printf("총 수익률은 %.2f 입니다.\n", profitRate);
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
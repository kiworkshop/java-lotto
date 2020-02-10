package view.output;

import domain.lotto.Lotto;
import domain.lotto.UserLottos;
import domain.result.Rank;
import domain.result.UserRanks;

import java.util.List;

public class LottoOutputPrinter {

    private static final String RANK_FORMAT = "%d개 일치 (%d원) - %d개";

    public static void printUserLottos(UserLottos userLottos) {
        List<Lotto> lottoList = userLottos.getLottos();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printUserRanks(UserRanks userRanks) {
        printHead();
        printRanks(userRanks);
        printProfitRate(userRanks);
    }

    private static void printHead() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------");
    }

    private static void printRanks(UserRanks userRanks) {
        System.out.println("3개 일치 (5000원) - " + userRanks.count(Rank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원) - " + userRanks.count(Rank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원) - " + userRanks.count(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + userRanks.count(Rank.FIRST) + "개");
    }

    private static void printProfitRate(UserRanks userRanks) {
        System.out.println(String.format("총 수익률은 %f 입니다", userRanks.getProfitRate()));
    }
}

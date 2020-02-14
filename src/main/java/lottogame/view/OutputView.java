package lottogame.view;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;
import lottogame.domain.statistics.WinningLotto;
import lottogame.domain.statistics.WinningLottos;

public class OutputView {

    private static final String MESSAGE_PRINT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String MESSAGE_PRINT_LOTTO_RESULT = "당첨 통계";

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + MESSAGE_PRINT_LOTTO_COUNT);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.toString());
    }

    public void printWinningStatistics(WinningLottos winningLottos) {
        printHeader();

        printResult(winningLottos);
    }

    private void printHeader() {
        System.out.println();
        System.out.println(MESSAGE_PRINT_LOTTO_RESULT);
        System.out.println("---------");
    }

    private void printResult(WinningLottos winningLottos) {
        System.out.println("3개 일치 (5000원) - " + winningLottos.countLottoStatistics(WinningLotto.FOURTH) + "개");
        System.out.println("4개 일치 (50000원) - " + winningLottos.countLottoStatistics(WinningLotto.THIRD) + "개");
        System.out.println("5개 일치 (1500000원) - " + winningLottos.countLottoStatistics(WinningLotto.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winningLottos.countLottoStatistics(WinningLotto.FIRST) + "개");
    }

    public void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + (int) earningRate + "%입니다.");
    }
}
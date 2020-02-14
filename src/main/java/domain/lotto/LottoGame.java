package domain.lotto;

import domain.lotto.ticket.LottoTicket;
import domain.lotto.ticket.UserLottoTicket;
import domain.lotto.ticket.WinningLottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int NUMBER_OF_BALLS = 6;

    public final int NUM_MATCH_FOR_FIRST_PLACE = 6;
    public final long PRIZE_FOR_FIRST_PLACE = 2000000000;
    public final int NUM_MATCH_FOR_SECOND_PLACE = 5;
    public final long PRIZE_FOR_SECOND_PLACE = 1500000;
    public final int NUM_MATCH_FOR_THIRD_PLACE = 4;
    public final long PRIZE_FOR_THIRD_PLACE = 50000;
    public final int NUM_MATCH_FOR_FOURTH_PLACE = 3;
    public final long PRIZE_FOR_FOURTH_PLACE = 5000;

    public enum WinningPlace {
        FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, NOTHING
    }

    public enum GameProgress {
        IN_PROGRESS,
        FINISHED
    }

    private WinningLottoTicket winningLottoTicket;
    private GameProgress gameProgress;

    public LottoGame() {
        gameProgress = GameProgress.IN_PROGRESS;
    }

    public List<LottoTicket> buyLottoTickets(long money) {
        List<LottoTicket> tickets = new ArrayList<>();
        long numTickets = money / LOTTO_PRICE;
        for (long i = 0; i < numTickets; i++) {
            tickets.add(new UserLottoTicket().ofRandom());
        }
        return tickets;
    }

    public void finishLottoGame(WinningLottoTicket winningLottoTicket) {
        gameProgress = GameProgress.FINISHED;
        this.winningLottoTicket = winningLottoTicket;
    }

    public void getStatisticResult(LottoWallet wallet) {
        int numFirstPlace = 0;
        int numSecondPlace = 0;
        int numThirdPlace = 0;
        int numFourthPlace = 0;
        long totalRevenue = 0;
        for (LottoTicket ticket: wallet.getTickets()) {
            WinningPlace winningPlace = checkWinningPlace(ticket);
            if (winningPlace == WinningPlace.FIRST_PLACE) {
                numFirstPlace++;
            } else if (winningPlace == WinningPlace.SECOND_PLACE) {
                numSecondPlace++;
            } else if (winningPlace == WinningPlace.THIRD_PLACE) {
                numThirdPlace++;
            } else if (winningPlace == WinningPlace.FOURTH_PLACE) {
                numFourthPlace++;
            }
        }

        totalRevenue = numFirstPlace * PRIZE_FOR_FIRST_PLACE
                + numSecondPlace * PRIZE_FOR_SECOND_PLACE
                + numThirdPlace * PRIZE_FOR_THIRD_PLACE
                + numFourthPlace * PRIZE_FOR_FOURTH_PLACE;

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("%d개 일치 (%d원)-%2d개\n", NUM_MATCH_FOR_FOURTH_PLACE, PRIZE_FOR_FOURTH_PLACE, numFourthPlace);
        System.out.printf("%d개 일치 (%d원)-%2d개\n", NUM_MATCH_FOR_THIRD_PLACE, PRIZE_FOR_THIRD_PLACE, numThirdPlace);
        System.out.printf("%d개 일치 (%d원)-%2d개\n", NUM_MATCH_FOR_SECOND_PLACE, PRIZE_FOR_SECOND_PLACE, numSecondPlace);
        System.out.printf("%d개 일치 (%d원)-%2d개\n", NUM_MATCH_FOR_FIRST_PLACE, PRIZE_FOR_FIRST_PLACE, numFirstPlace);
        System.out.println("총 수익률은 " + (int) (100 * totalRevenue / wallet.getTickets().size() / LottoGame.LOTTO_PRICE) + "%입니다.");
    }

    private WinningPlace checkWinningPlace(LottoTicket ticket) {
        int numMatchingNumbers = ticket.getNumMatchingNumbers(winningLottoTicket.getChosenNumbers());
        if (numMatchingNumbers == NUM_MATCH_FOR_FIRST_PLACE) {
            return WinningPlace.FIRST_PLACE;
        } else if (numMatchingNumbers == NUM_MATCH_FOR_SECOND_PLACE) {
            return WinningPlace.SECOND_PLACE;
        } else if (numMatchingNumbers == NUM_MATCH_FOR_THIRD_PLACE) {
            return WinningPlace.THIRD_PLACE;
        } else if (numMatchingNumbers == NUM_MATCH_FOR_FOURTH_PLACE) {
            return WinningPlace.FOURTH_PLACE;
        } else {
            return WinningPlace.NOTHING;
        }
    }
}

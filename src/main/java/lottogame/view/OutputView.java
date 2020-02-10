package lottogame.view;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.domain.lottoticket.LottoTickets;

public class OutputView {

    private static final String MESSAGE_PRINT_LOTTO_COUNT = "개를 구매했습니다.";

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
}
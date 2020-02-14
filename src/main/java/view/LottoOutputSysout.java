package view;

import domain.lotto.ticket.LottoTicket;

import java.util.List;

public class LottoOutputSysout {

    private static final String MESSAGE_NUM_TICKET_PURCHASE = "개를 구매했습니다.";

    public static void responseLottoPurchaseInfo(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + MESSAGE_NUM_TICKET_PURCHASE);
        for (LottoTicket ticket: tickets) {
            System.out.println(ticket);
        }
    }
}

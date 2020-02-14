package view;

import domain.lotto.ticket.LottoTicket;
import domain.lotto.ticket.WinningLottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputSysin {

    private static final String MESSAGE_ASK_HOW_MUCH = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_ASK_WINNING_TICKET_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static long requestMoneyForLottoTickets() {
        System.out.println(MESSAGE_ASK_HOW_MUCH);
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static WinningLottoTicket requestWinningTicketNumber() {
        System.out.println(MESSAGE_ASK_WINNING_TICKET_NUMBER);
        try {
            List<Integer> numbers = Arrays.stream(
                    scanner.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new WinningLottoTicket().ofGiven(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

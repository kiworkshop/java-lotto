import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    public static final int LOTTO_PRICE = 1000;

    public static List<LottoTicket> buyLottoTickets(int money) {
        List<LottoTicket> tickets = new ArrayList<>();
        int numTickets = money / LOTTO_PRICE;
        for (int i = 0; i < numTickets; i++) {
            tickets.add(new LottoTicket().ofRandom());
        }
        System.out.println("" + numTickets + "개를 구매했습니다.");
        return tickets;
    }
}

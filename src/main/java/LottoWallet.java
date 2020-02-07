import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    List<LottoTicket> tickets = new ArrayList<>();

    public void addLottoTickets(List<LottoTicket> tickets) {
        this.tickets.addAll(tickets);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (LottoTicket ticket: tickets) {
            output.append(ticket).append("\n");
        }
        return output.toString();
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}

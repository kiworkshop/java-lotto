package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
  private final List<LottoTicket> lottoTickets;

  private LottoTickets(List<LottoTicket> tickets) {
    this.lottoTickets = tickets;
  }

  public static LottoTickets of(List<LottoTicket> tickets) {
    return new LottoTickets(tickets);
  }

  public List<LottoTicket> getLottoTickets() {
    return Collections.unmodifiableList(lottoTickets);
  }

  public int size() {
    return lottoTickets.size();
  }

  public void show() {
    for (LottoTicket lottoTicket : lottoTickets) {
      lottoTicket.showLottoNumbers();
    }
  }
}

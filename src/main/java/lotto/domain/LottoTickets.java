package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
  private List<LottoTicket> lottoTickets = new ArrayList<>();
  private int numOfManual;
  private int numOfAuto;

  private LottoTickets(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
    this.lottoTickets = Stream.concat(manualTickets.stream(), autoTickets.stream())
        .collect(Collectors.toList());
    this.numOfManual = manualTickets.size();
    this.numOfAuto = autoTickets.size();
  }

  public static LottoTickets of(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
    return new LottoTickets(manualTickets, autoTickets);
  }

  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }

  public int getNumOfManual() {
    return numOfManual;
  }

  public int getNumOfAuto() {
    return numOfAuto;
  }

  public void show() {
    for (LottoTicket lottoTicket : lottoTickets) {
      lottoTicket.showLottoNumbers();
    }
  }
}

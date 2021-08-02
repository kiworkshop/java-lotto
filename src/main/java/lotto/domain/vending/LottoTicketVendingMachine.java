package lotto.domain.vending;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketVendingMachine {
    private final LottoGenerator lottoGenerator;

    public LottoTicketVendingMachine() {
        this.lottoGenerator = new LottoGenerator();
    }

    public LottoTickets issueTickets(int autoTicketAmount, List<List<Integer>> manualLottoNumbers) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(manualLottoTickets(manualLottoNumbers));
        lottoTickets.add(autoIssueTickets(autoTicketAmount));
        return lottoTickets;
    }

    public List<LottoTicket> autoIssueTickets(int autoTicketAmount) {
        return IntStream.range(0, autoTicketAmount)
                .mapToObj(i -> lottoGenerator.issueAutoLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public List<LottoTicket> manualLottoTickets(List<List<Integer>> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(manualNumbers -> manualNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()))
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }
}

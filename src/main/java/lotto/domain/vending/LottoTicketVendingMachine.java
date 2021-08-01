package lotto.domain.vending;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketVendingMachine {

    private final LottoGenerator lottoGenerator;

    public LottoTicketVendingMachine() {
        this.lottoGenerator = new LottoGenerator();
    }

    public List<LottoTicket> autoIssueTickets(TicketAmount ticketAmount) {
        return IntStream.range(0, ticketAmount.auto())
                .mapToObj(i -> lottoGenerator.issueAutoLottoNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public List<LottoTicket> manualIssueTickets(List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(StringUtil::split)
                .map(manualNumbers -> manualLottoTicket(manualNumbers))
                .collect(Collectors.toList());
    }

    private LottoTicket manualLottoTicket(List<String> manualNumbers) {
        List<LottoNumber> lottoNumbers = manualNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumbers);
    }

    public LottoTickets issueTickets(TicketAmount ticketAmount, List<String> inputManualNumbers) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(manualIssueTickets(inputManualNumbers));
        lottoTickets.add(autoIssueTickets(ticketAmount));
        return lottoTickets;
    }
}

package lotto.domain.vending;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE;

public class LottoTicketVendingMachine {

    public LottoTickets issueTickets(int autoTicketAmount, List<List<Integer>> manualLottoNumbers) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(manualLottoTickets(manualLottoNumbers));
        lottoTickets.add(autoIssueTickets(autoTicketAmount));
        return lottoTickets;
    }

    public List<LottoTicket> autoIssueTickets(int autoTicketAmount) {
        return IntStream.range(0, autoTicketAmount)
                .mapToObj(i -> issueAutoLottoNumbers())
                .map(LottoTicket::from)
                .collect(Collectors.toList());
    }

    public Set<LottoNumber> issueAutoLottoNumbers() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(LOTTO_NUMBER_SIZE)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    public List<LottoTicket> manualLottoTickets(List<List<Integer>> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(manualNumbers -> manualNumbers.stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet()))
                .map(LottoTicket::from)
                .collect(Collectors.toList());
    }
}

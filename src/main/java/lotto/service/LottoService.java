package lotto.service;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.util.StringUtil;
import lotto.domain.vending.LottoTicketVendingMachine;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoTicketVendingMachine vendingMachine;

    public LottoService() {
        this.vendingMachine = new LottoTicketVendingMachine();
    }

    public LottoTickets issueTickets(int autoTicketAmount, List<String> inputManualNumbers) {
        List<List<Integer>> manualLottoNumbers = manualLottoNumbers(inputManualNumbers);
        return vendingMachine.issueTickets(autoTicketAmount, manualLottoNumbers);
    }

    public List<List<Integer>> manualLottoNumbers(List<String> inputManualNumbers) {
        return inputManualNumbers.stream()
                .map(StringUtil::split)
                .map(this::parseLottoNumbers)
                .collect(Collectors.toList());
    }

    private List<Integer> parseLottoNumbers(List<String> inputManualNumbers) {
        try {
            return inputManualNumbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }

    public float getProfitRate(int totalTicketAmount, WinningLottoRank winningLottoRank) {
        WinningStatistics winningStatistics = new WinningStatistics(winningLottoRank);
        return winningStatistics.profitRate(totalTicketAmount);
    }

    public WinningLottoRank getWinningLottoRank(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        try {
            WinningLottoRank winningLottoRank = new WinningLottoRank(lottoTickets, winningNumbers);
            OutputView.printWinningStatistics(winningLottoRank);
            return winningLottoRank;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자를 입력해 주세요.");
        }
    }
}

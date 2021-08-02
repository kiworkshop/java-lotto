package lotto.controller;

import lotto.domain.lotto.LottoTickets;
import lotto.domain.util.StringUtil;
import lotto.domain.vending.BuyingPrice;
import lotto.domain.vending.TicketAmount;
import lotto.domain.winning.WinningLottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public BuyingPrice getBuyingPrice(String price) throws NumberFormatException {
        try {
            return new BuyingPrice(Integer.parseInt(price));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구매 금액은 숫자로 입력해 주세요.");
        }
    }

    public TicketAmount getTicketAmount(int totalTicketAmount, String manualTicketAmount) {
        try {
            return new TicketAmount(totalTicketAmount, Integer.parseInt(manualTicketAmount));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동 티켓 개수는 숫자로 입력해 주세요.");
        }
    }

    public LottoTickets issueTickets(TicketAmount ticketAmount) {
        List<String> inputManualNumbers = InputView.getManualNumbers(ticketAmount.manual());
        return lottoService.issueTickets(ticketAmount.auto(), inputManualNumbers);
    }

    public WinningNumbers validateWinningLottoNumbers(String inputWinningNumbers, String inputBonusNumber) {
        try {
            List<Integer> splitWinningNumbers = StringUtil.splitParseInt(inputWinningNumbers);
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return new WinningNumbers(splitWinningNumbers, bonusNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동 로또 번호는은 숫자로 입력해 주세요.");
        }
    }

    public float calculateProfitRate(int totalTicketAmount, LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        WinningLottoRank winningLottoRank = lottoService.getWinningLottoRank(lottoTickets, winningNumbers);
        return lottoService.getProfitRate(totalTicketAmount, winningLottoRank);
    }
}

package lotto.controller;

import static lotto.util.InputUtil.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTickets;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;
import lotto.service.TicketService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoController {
  private TicketService ticketService = new TicketService();
  private ConsoleInputView consoleInputView;
  private ConsoleOutputView consoleOutputView;

  public LottoController(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
    this.consoleInputView = consoleInputView;
    this.consoleOutputView = consoleOutputView;
  }

  public void run() {
    LottoPurchase lottoPurchase = purchaseLottos();
    LottoTickets lottoTickets = createAndShowLottoTickets(lottoPurchase);
    WinningLotto winningLotto = generateWinningLotto();
    Prizes prizes = winningLotto.calculateResult(lottoTickets);
    consoleOutputView.showResult(prizes);
  }

  private LottoPurchase purchaseLottos() {
    int totalPrice = parseStringToInt(consoleInputView.getPriceInput());
    LottoPurchase lottoPurchase = LottoPurchase.of(totalPrice);

    int numOfManualLotto = parseStringToInt(consoleInputView.getNumOfManualLotto());
    lottoPurchase.setNumOfManualLottos(numOfManualLotto);
    return lottoPurchase;
  }

  private LottoTickets createAndShowLottoTickets(LottoPurchase lottoPurchase) {
    List<String> manualInput = consoleInputView.getManualLottoNumbers(lottoPurchase.getNumOfManualLottos());
    LottoTickets manualTickets = ticketService.toManualLottoTickets(manualInput);
    LottoTickets randomTickets = ticketService.toRandomLottoTickets(lottoPurchase);
    consoleOutputView.showLottoTickets(manualTickets, randomTickets);

    return LottoTickets.of(Stream.concat(manualTickets.getLottoTickets().stream(), randomTickets.getLottoTickets().stream())
        .collect(Collectors.toList()));
  }

  private WinningLotto generateWinningLotto() {
    String winningNumbersInput = consoleInputView.getWinningNumbers();
    int bonusBallInput = parseStringToInt(consoleInputView.getWinningNumbers());
    return ticketService.generateWinningLotto(winningNumbersInput, bonusBallInput);
  }
}

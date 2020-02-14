package lotto.controller;

import static lotto.util.InputUtil.*;

import java.util.List;

import lotto.domain.LottoPurchase;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Prizes;
import lotto.domain.WinningLotto;
import lotto.service.TicketService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoController {
  private TicketService ticketService = new TicketService();

  // TODO: 2020-02-15 private method, service로 분리하기
  public void run(ConsoleInputView consoleInputView, ConsoleOutputView consoleOutputView) {
    int totalPrice = parseStringToInt(consoleInputView.getPriceInput());
    int numOfManualLotto = parseStringToInt(consoleInputView.getNumOfManualLotto());
    LottoPurchase lottoPurchase = LottoPurchase.of(totalPrice, numOfManualLotto);

    List<LottoTicket> manualLottoTickets = ticketService.toLottoTickets(
        consoleInputView.getManualLottoNumbers(numOfManualLotto));
    List<LottoTicket> autoLottoTickets = ticketService.generateLottoTickets(lottoPurchase);
    LottoTickets lottoTickets = LottoTickets.of(manualLottoTickets, autoLottoTickets);

    consoleOutputView.showLottoTickets(lottoTickets);

    String winningNumbersInput = consoleInputView.getWinningNumbers();
    int bonusBallInput = parseStringToInt(consoleInputView.getWinningNumbers());
    WinningLotto winningLotto = ticketService.generateWinningLotto(winningNumbersInput, bonusBallInput);
    Prizes prizes = winningLotto.calculateResult(lottoTickets);
    consoleOutputView.showResult(prizes);
  }
}

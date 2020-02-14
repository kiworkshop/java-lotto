package controller;

import domain.lotto.LottoGame;
import domain.lotto.ticket.LottoTicket;
import domain.lotto.LottoWallet;
import domain.lotto.ticket.WinningLottoTicket;
import view.LottoInputSysin;
import view.LottoOutputSysout;

import java.util.List;

public class LottoGameController {

    LottoGame lottoGame = new LottoGame();
    LottoWallet myWallet = new LottoWallet();

    public void run() {
        buyLottoTickets();
        getLottoGameResult();
    }

    private void buyLottoTickets() {
        long money = LottoInputSysin.requestMoneyForLottoTickets();
        List<LottoTicket> tickets = lottoGame.buyLottoTickets(money);
        LottoOutputSysout.responseLottoPurchaseInfo(tickets);
        myWallet.addLottoTickets(tickets);
    }

    private void getLottoGameResult() {
        WinningLottoTicket winningLottoTicket = LottoInputSysin.requestWinningTicketNumber();
        lottoGame.finishLottoGame(winningLottoTicket);
        lottoGame.getStatisticResult(myWallet);
    }
}

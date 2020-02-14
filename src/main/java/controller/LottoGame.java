package controller;

import domain.LottoMarket;
import domain.LottoResult;
import domain.LottoTicket;
import domain.LottoWallet;
import view.LottoInputSysin;
import view.LottoOutputSysout;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGame {

    private Scanner scanner = new Scanner(System.in);
    LottoWallet myWallet = new LottoWallet();

    public void start() {
        buyLotto();
        enterWinningTicketNumber();
    }

    private void buyLotto() {
        long money = LottoInputSysin.requestMoneyForLottoTickets();
        List<LottoTicket> tickets = LottoMarket.buyLottoTickets(money);
        LottoOutputSysout.responseLottoPurchaseInfo(tickets);
        myWallet.addLottoTickets(tickets);
    }

    private void enterWinningTicketNumber() {
        LottoTicket winningTicket = LottoInputSysin.requestWinningTicketNumber();
        LottoResult lottoResult = new LottoResult(winningTicket);
        lottoResult.getStatisticResult(myWallet);
    }
}

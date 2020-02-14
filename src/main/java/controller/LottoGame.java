package controller;

import domain.LottoMarket;
import domain.LottoResult;
import domain.LottoTicket;
import domain.LottoWallet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGame {

    private Scanner scanner = new Scanner(System.in);
    LottoWallet wallet = new LottoWallet();

    public void start() {
        buyLotto();
        enterWinningNumber();
    }

    private void buyLotto() {
        int money = askHowMuch();
        wallet.addLottoTickets(LottoMarket.buyLottoTickets(money));
        System.out.println(wallet);
    }

    private int askHowMuch() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private void enterWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String numbers = scanner.nextLine();
        LottoTicket winningTicket = new LottoTicket().ofGiven(
                Arrays.stream(numbers.split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
        LottoResult lottoResult = new LottoResult(winningTicket);
        lottoResult.getStatisticResult(wallet);
    }
}

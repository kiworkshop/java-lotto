package controller;

import domain.lotto.Lotto;
import domain.lotto.LottoFactory;
import domain.lotto.LottoNumber;
import domain.lotto.UserLottos;
import domain.lotto.WinningLotto;
import domain.money.LottoMoney;
import domain.result.Rank;
import domain.result.UserRanks;
import view.input.LottoInputScanner;
import view.output.LottoOutputPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = getMoneyFromUser();
        UserLottos userLottos = getUserLottos(lottoMoney);
        LottoOutputPrinter.printUserLottos(userLottos);
        WinningLotto winningLotto = getWinningLotto();
        UserRanks userRanks = getUserRank(winningLotto, userLottos);
        LottoOutputPrinter.printUserRanks(userRanks);
    }

    private LottoMoney getMoneyFromUser() {
        int moneyFromUser = parseMoneyToInt(inputMoneyFromUser());
        return LottoMoney.from(moneyFromUser);
    }

    private String inputMoneyFromUser() {
        return LottoInputScanner.askLottoPurchacePrice();
    }

    private int parseMoneyToInt(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private UserLottos getUserLottos(LottoMoney lottoMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoMoney.getCountOfLotto(); i++) {
            lottos.add(LottoFactory.publishLotto());
        }

        return UserLottos.from(lottos);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = parseInputToLotto(LottoInputScanner.askLottoWinningNumber());
        LottoNumber bonusNumber = parseInputToBonusNumber(LottoInputScanner.askBonusNumber());
        return WinningLotto.from(winningLotto, bonusNumber);
    }

    private Lotto parseInputToLotto(String input) {
        List<String> lottoNumbers = Arrays.asList(input.split(","));
        Set<LottoNumber> lottoNumberSet = lottoNumbers.stream()
                .mapToInt(number -> Integer.parseInt(number.trim()))
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());

        return Lotto.from(lottoNumberSet);
    }

    private LottoNumber parseInputToBonusNumber(String input) {
        try {
            return LottoNumber.from(Integer.parseInt(input));
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException();
        }
    }

    private UserRanks getUserRank(WinningLotto winningLotto, UserLottos userLottos) {
        List<Lotto> lottos = userLottos.getLottos();
        List<Rank> ranks = lottos.stream()
                .map(winningLotto::getRank)
                .collect(Collectors.toList());

        return new UserRanks(ranks);
    }

}

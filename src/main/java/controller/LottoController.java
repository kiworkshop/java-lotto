package controller;

import domain.lotto.Lotto;
import domain.lotto.LottoFactory;
import domain.lotto.LottoNumber;
import domain.lotto.UserLottos;
import domain.lotto.WinningLotto;
import domain.money.LottoMoney;
import domain.result.Rank;
import domain.result.UserRanks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {

    public LottoMoney createMoney(String inputMoneyFromUser) {
        return LottoMoney.from(parseMoneyToInt(inputMoneyFromUser));
    }

    public UserLottos publishUserLottos(LottoMoney lottoMoney) {
        return getUserLottos(lottoMoney);
    }

    public WinningLotto createWinningLotto(String inputLotto, String inputBonus) {
        Lotto winningLotto = parseInputToLotto(inputLotto);
        LottoNumber bonusNumber = parseInputToBonusNumber(inputBonus);
        return WinningLotto.from(winningLotto, bonusNumber);
    }

    public UserRanks createUserRanks(WinningLotto winningLotto, UserLottos userLottos) {
        return getUserRank(winningLotto, userLottos);
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

package com.study.domain;

import com.study.enums.Rank;
import com.study.enums.RankMap;
import com.study.utils.InputValidation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final int lottoTotalTicketCount;
    private final int lottoAutoTicketCount;
    private final int lottoManualTicketCount;
    private final int money;
    private static InputValidation inputValidation = new InputValidation();
    private final static LottoValication LOTTO_VALIDATION = new LottoValication();

    public LottoMachine(String inputMoney) {
        this.money = LOTTO_VALIDATION.checkGivenMoney(inputMoney);
        this.lottoTotalTicketCount = this.money / LOTTO_VALIDATION.LOTTO_PRICE;
        lottoManualTicketCount = lottoTotalTicketCount;
        lottoAutoTicketCount = 0;
    }

    public LottoMachine(String inputMoney, int manualTicketCount) {
        this.money = LOTTO_VALIDATION.checkGivenMoney(inputMoney);
        LOTTO_VALIDATION.canbyAllTickets(money, manualTicketCount);
        this.lottoTotalTicketCount = this.money / LOTTO_VALIDATION.LOTTO_PRICE;
        this.lottoManualTicketCount = manualTicketCount;
        this.lottoAutoTicketCount = lottoTotalTicketCount - lottoManualTicketCount;
    }

    public int getLottoTicketCount() {
        return this.lottoTotalTicketCount;
    }

    public int getLottoManualTicketCount() {
        return lottoManualTicketCount;
    }

    public List<Integer> createRandomNumber() {
        List<Integer> balls = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(balls);
        List<Integer> lottoNumbers = balls.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> getLottoTotalTickets(List<List<Integer>> manualLottos) {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(getLottoManulTickets(manualLottos));
        lottoTickets.addAll(getAutoLottoTickets());
        return lottoTickets;
    }

    public List<Lotto> getAutoLottoTickets() {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < lottoAutoTicketCount; i++) {
            lottoTicket.add(new Lotto(createRandomNumber()));
        }
        return lottoTicket;
    }

    public List<Lotto> getLottoManulTickets(List<List<Integer>> manualLottos) {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < lottoManualTicketCount; i++) {
            lottoTicket.add(new Lotto(manualLottos.get(i)));
        }
        return lottoTicket;
    }

    public int getBonusBall(String bonusInput, List<Integer> winningNumber) {
        int bonusInputNumber = Integer.parseInt(bonusInput);
        LOTTO_VALIDATION.checkBound(bonusInputNumber);
        LOTTO_VALIDATION.checkBonusDuplicate(bonusInputNumber, winningNumber);
        return bonusInputNumber;
    }

    public RankMap getRankResult(Lottos lottos, List<Integer> winningNumber, int bonusNumber) {
        RankMap rankMap = new RankMap(Rank.class);
        for (Lotto lotto : lottos.getLottos()) {
            rankMap.put(lotto.getRank(winningNumber, bonusNumber), rankMap.get(lotto.getRank(winningNumber, bonusNumber)) + 1);
        }
        return rankMap;
    }

    public double getProfitRate(Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble(rank -> rank.getKey().prize() * rank.getValue())
                .sum();
        return totalPrize / this.money;
    }

    public List<Integer> getWinningNumber(String winningNumber) {
        List<Integer> winningNumbers = inputValidation.toIntegers(inputValidation.splitByComma(winningNumber));
        LOTTO_VALIDATION.lottoNumberValidate(winningNumbers);
        return winningNumbers;
    }

}

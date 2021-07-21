package com.study.domain;

import com.study.enums.Rank;
import com.study.utils.InputValidation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final int lottoTicketCount;
    private final int money;
    private static InputValidation inputValidation = new InputValidation();
    private final LottoValication lottoValication= new LottoValication();

    public LottoMachine(String inputMoney) {
        this.money = lottoValication.checkGivenMoney(inputMoney);
        this.lottoTicketCount = this.money / lottoValication.LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return this.lottoTicketCount;
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

    public List<Lotto> getLottoTickets() {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTicket.add(new Lotto(createRandomNumber()));
        }
        return lottoTicket;
    }
    public int getBonusBall(String bonusInput, List<Integer> winningNumber) {
        int bonusInputNumber = Integer.parseInt(bonusInput);
        lottoValication.checkBound(bonusInputNumber);
        lottoValication.checkBonusDuplicate(bonusInputNumber, winningNumber);
        return bonusInputNumber;
    }
    public TreeMap getRankResult(Lottos lottos, List<Integer> winningNumber, int bonusNumber) {

        TreeMap<Rank, Integer> result = new TreeMap<Rank, Integer>() {{
            put(Rank.FIRST_PLACE, 0);
            put(Rank.SECOND_PLACE, 0);
            put(Rank.THIRD_PLACE, 0);
            put(Rank.FOURTH_PLACE, 0);
            put(Rank.FIFTH_PLACE, 0);
            put(Rank.ETC, 0);
        }};

        for (Lotto lotto : lottos.getLottos()) {
            result.put(lotto.getRank(winningNumber, bonusNumber), result.get(lotto.getRank(winningNumber, bonusNumber)) + 1);
        }
        return result;
    }

    public double getProfitRate(Map<Rank, Integer> rankResult) {
        double totalPrize = rankResult.entrySet()
                .stream()
                .mapToDouble((rank) -> rank.getKey().prize() * rank.getValue())
                .sum();
        return totalPrize / this.money;
    }

     public List<Integer> getWinningNumber(String winningNumber) {
        List<Integer> winningNumbers = inputValidation.toIntegers(inputValidation.splitByComma(winningNumber));
         lottoValication.winningNumberValidate(winningNumbers);
        return winningNumbers;
    }

}

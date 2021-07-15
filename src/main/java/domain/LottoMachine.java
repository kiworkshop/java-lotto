package domain;

import enums.Rank;
import utils.InputValidation;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;
    private static final String LOTTO_PRICE_PATTERN = "\\d*000";
    private final int money;
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 45;
    private static final int LOTTO_LENGTH = 6;
    private static InputValidation inputValidation = new InputValidation();
    private static final String ALERT_CHECK_BOUND = String.format("당첨번호는 %d - %d 사이값을 입력해주세요", BOUND_MIN, BOUND_MAX);
    private static final String ALERT_CHECK_LENGTH = String.format("당첨번호는 %d개 이어야 합니다.", LOTTO_LENGTH);
    private static final String ALERT_CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private static final String ALERT_CHECK_BONUS_DUPLICATE = "보너스볼이 당첨 번호와 중복되는지 확인해주세요.";

    public LottoMachine(String inputMoney) {
        this.money = checkGivenMoney(inputMoney);
        this.lottoTicketCount = this.money / LOTTO_PRICE;
    }

    private int checkGivenMoney(String givenMoney) {
        if (!Pattern.matches(LOTTO_PRICE_PATTERN, givenMoney)) {
            throw new RuntimeException("1000원 단위의 금액만 투입할 수 있습니다.");
        }
        return Integer.parseInt(givenMoney);
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

    public TreeMap getRankResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {

        TreeMap<Rank, Integer> result = new TreeMap<Rank, Integer>() {{
            put(Rank.FIRST_PLACE, 0);
            put(Rank.SECOND_PLACE, 0);
            put(Rank.THIRD_PLACE, 0);
            put(Rank.FOURTH_PLACE, 0);
            put(Rank.FIFTH_PLACE, 0);
            put(Rank.ETC, 0);
        }};

        for (Lotto lotto : lottos) {
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
        winningNumberValidate(winningNumbers);
        return winningNumbers;
    }
    private void winningNumberValidate(List<Integer> winningNumbers) {
        checkListBound(winningNumbers);
        checkLength(winningNumbers);
        checkDuplicate(winningNumbers);
    }

    private void checkListBound(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            checkBound(winningNumber);
        }
    }

    public void checkBound(int number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(ALERT_CHECK_BOUND);
        }
    }

    private void checkLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ALERT_CHECK_LENGTH);

        }
    }

    private void checkDuplicate(List<Integer> winningNumbers) {
        int countOfDeDuplication = (int) winningNumbers.stream()
                .distinct()
                .count();

        if (countOfDeDuplication != winningNumbers.size()) {
            throw new IllegalArgumentException(ALERT_CHECK_DUPLICATION);
        }
    }
    public int getBonusBall(String bonusInput, List<Integer> winningNumber) {
        int bonusInputNumber = Integer.parseInt(bonusInput);
        checkBound(bonusInputNumber);
        checkBonusDuplicate(bonusInputNumber, winningNumber);
        return bonusInputNumber;
    }
    private void checkBonusDuplicate(int bonusInputNumber, List<Integer> winningNumber) {
        boolean isDuplicate = winningNumber.stream()
                .anyMatch(number -> bonusInputNumber == number);

        if (isDuplicate) {
            throw new IllegalArgumentException(ALERT_CHECK_BONUS_DUPLICATE);
        }
    }
}

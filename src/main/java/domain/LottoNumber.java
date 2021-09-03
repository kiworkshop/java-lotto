package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 45;
    private static final String ALERT_CHECK_BOUND = String.format("당첨번호는 %d - %d 사이값을 입력해주세요", BOUND_MIN, BOUND_MAX);

    private static final Map<Integer, LottoNumber> CACHED_NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), LottoNumber::new));

    private final int number;

    private LottoNumber(int number) {
        validateBound(number);
        this.number = number;
    }

    public static LottoNumber of(String input) {
        int lottoNumber = 0;
        try {
            lottoNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage()); // customException 처리
        }
        return CACHED_NUMBERS.get(lottoNumber);
    }

    private void validateBound(int number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(ALERT_CHECK_BOUND);
        }
    }
}

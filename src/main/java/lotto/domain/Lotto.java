package lotto.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.exception.ExceptionMessage.DUPLICATE_LOTTO_NUMBER_INPUT_FOR_LOTTO;
import static lotto.exception.ExceptionMessage.INVALID_LENGTH_INPUT_FOR_LOTTO;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;

    @Getter
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);

        numbers.sort(Integer::compare);
        this.lottoNumbers = Collections.unmodifiableList(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT_FOR_LOTTO.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_INPUT_FOR_LOTTO.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

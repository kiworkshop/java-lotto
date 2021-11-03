package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet()));
    }

    public static LottoTicket from(Set<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private static void validation(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(new HashSet<>(lottoNumbers));
    }

    private static void validateSize(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() > LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private static void validateDuplication(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다.");
        }
    }

    public Set<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}

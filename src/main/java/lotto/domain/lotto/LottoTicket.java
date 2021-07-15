package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validation(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoTicket(int... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private void validation(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplication(new HashSet<>(lottoNumbers));
    }

    private void validateSize(List<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }

    private void validateDuplication(Set<LottoNumber> lottoNumberSet) {
        if (lottoNumberSet.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다.");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}

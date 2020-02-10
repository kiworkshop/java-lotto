package domain.lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        return new Lotto(lottoNumbers);
    }

    int match(Lotto targetLotto) {
        return (int) lottoNumbers.stream().filter(targetLotto::contains).count();
    }

    boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        List<LottoNumber> lottoNumberList = lottoNumbers.stream()
                .sorted().collect(Collectors.toList());
        return lottoNumberList.toString();
    }
}

package domain;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;
    public Lotto(List<Integer> randomNumber) {
        this.lottoNumbers = randomNumber;
    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

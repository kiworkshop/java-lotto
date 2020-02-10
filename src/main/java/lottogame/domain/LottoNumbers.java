package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public LottoNumbers() {
        this.lottoNumbers = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<Integer> selectLottoNumbersBy(int boundaryIndex) {
        return lottoNumbers.subList(0, boundaryIndex);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

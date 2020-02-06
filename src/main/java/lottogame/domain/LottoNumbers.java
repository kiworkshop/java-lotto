package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;


    public LottoNumbers() {
        this.lottoNumbers  = generateLottoNumbers();
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}

package lottogame.domain;

import java.util.Comparator;
import java.util.List;

public class LottoTicket {

    private static LottoNumbers lottoNumbers = new LottoNumbers();
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> selectedLottoNumbers;

    public LottoTicket(List<Integer> selectedLottoNumbers) {
        this.selectedLottoNumbers = selectedLottoNumbers;
    }

    public static LottoTicket generateLottoTicket() {
        lottoNumbers.shuffle();

        List<Integer> selectedLottoNumbers = lottoNumbers.selectLottoNumbersBy(LOTTO_NUMBER_COUNT);

        List<Integer> sortedLottoNumbers = sortLottoNumbers(selectedLottoNumbers);

        return new LottoTicket(sortedLottoNumbers);
    }

    private static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return selectedLottoNumbers.toString();
    }
}

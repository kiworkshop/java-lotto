package lottogame.domain.lottoticket;

import lottogame.domain.LottoNumbers;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> selectedLottoNumbers;

    public LottoTicket() {
    }

    private LottoTicket(final List<Integer> selectedLottoNumbers) {
        this.selectedLottoNumbers = selectedLottoNumbers;
    }

    public LottoTicket generateLottoTicket() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.shuffle();

        List<Integer> selectedLottoNumbers = lottoNumbers.selectLottoNumbersBy(LOTTO_NUMBER_COUNT);

        List<Integer> sortedLottoNumbers = sortLottoNumbers(selectedLottoNumbers);

        return new LottoTicket(sortedLottoNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return selectedLottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(selectedLottoNumbers, that.selectedLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectedLottoNumbers);
    }
}

package lottogame.domain.lottoticket;

import lottogame.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private List<Integer> selectedLottoNumbers;

    public static LottoTicket of(String lottoNumbersString) {
        List<Integer> lottoNumbers = toLottoNumbers(lottoNumbersString);

        lottoNumbers.forEach(LottoNumbers::validateLottoNumber);

        List<Integer> sortedLottoNumbers = sortLottoNumbers(lottoNumbers);

        return new LottoTicket(sortedLottoNumbers);
    }

    private static List<Integer> toLottoNumbers(String lottoNumberString) {
        String[] lottoNumbers = lottoNumberString.split(LOTTO_NUMBER_DELIMITER);
        return Arrays.stream(lottoNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }

    public LottoTicket() {
    }

    private LottoTicket(final List<Integer> selectedLottoNumbers) {
        if(selectedLottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        this.selectedLottoNumbers = selectedLottoNumbers;
    }

    public LottoTicket generateLottoTicket() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.shuffle();

        List<Integer> selectedLottoNumbers = lottoNumbers.selectLottoNumbersBy(LOTTO_NUMBER_COUNT);

        List<Integer> sortedLottoNumbers = sortLottoNumbers(selectedLottoNumbers);

        return new LottoTicket(sortedLottoNumbers);
    }

    public List<Integer> getSelectedLottoNumbers() {
        return selectedLottoNumbers;
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

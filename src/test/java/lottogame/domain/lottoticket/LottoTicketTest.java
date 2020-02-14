package lottogame.domain.lottoticket;

import lottogame.domain.lottoticket.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

    String ascendingLottoNumbers;
    String descendingLottoNumbers;
    String wrongRangeLottoNumbers;
    String wrongCharacterLottoNumbers;
    String wrongSpaceLottoNumbers;
    String wrongCountLottoNumbers;

    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = "1,3,5,7,9,11";
        descendingLottoNumbers = "11,9,7,5,3,1";
        wrongRangeLottoNumbers = "47,1,2,3,4,5";
        wrongCharacterLottoNumbers = "c,1,2,3,4,5";
        wrongSpaceLottoNumbers = " ,1,2,3,4,5";
        wrongCountLottoNumbers= "1,2,3,4,5";
    }

    @Test
    void 주어진_String에_맞는_로또가_생성되어야한다() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(ascendingLottoNumbers);
        List<Integer> expected = generateList(ascendingLottoNumbers);

        // then
        assertThat(lottoTicket.getSelectedLottoNumbers()).isEqualTo(expected);
    }

    @Test
    void 로또숫자들이_오름차순으로_정렬되어야한다() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(descendingLottoNumbers);
        List<Integer> expected = generateList(ascendingLottoNumbers);

        // then
        assertThat(lottoTicket.getSelectedLottoNumbers()).isEqualTo(expected);
    }

    @Test
    void 잘못된_로또_숫자를_가질_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(wrongRangeLottoNumbers));
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(wrongCharacterLottoNumbers));
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(wrongSpaceLottoNumbers));
    }

    @Test
    void 로또숫자의_개수가_정확해야한다() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(wrongCountLottoNumbers));
    }


    private List<Integer> generateList(String lottoNumbers) {
        String[] numbers = lottoNumbers.split(",");

        List<Integer> expected = new ArrayList<>();
        for(String number : numbers) {
            expected.add(Integer.parseInt(number));
        }
        return expected;
    }

}
package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    private List<Integer> selectedLottoNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        selectedLottoNumbers.add(6);
        selectedLottoNumbers.add(5);
        selectedLottoNumbers.add(4);
        selectedLottoNumbers.add(3);
        selectedLottoNumbers.add(2);
        selectedLottoNumbers.add(1);
    }

    @Test
    void 로또숫자들이_오름차순으로_정렬되어야한다() {
        // given

        // when

        // then

    }
}
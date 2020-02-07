package lottogame.domain;

import lottogame.domain.lottoticket.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    String ascendingLottoNumbers;
    String descendingLottoNumbers;
    String wrongLottoResult;

    @BeforeEach
    void setUp() {
        ascendingLottoNumbers = "1, 3, 5, 7, 9, 11";
        descendingLottoNumbers = "11, 9, 7, 5, 3, 1";
        wrongLottoResult = "47, 1, 2, 3, 4, 5";
    }

    @Test
    void 주어진_String에_맞는_로또가_생성되어야한다() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(ascendingLottoNumbers);
        List<String> expected = Arrays.asList(ascendingLottoNumbers);

        // then
        assertThat(lottoTicket.toString()).isEqualTo(expected.toString());
    }

    @Test
    void 로또숫자들이_오름차순으로_정렬되어야한다() {
        // given
        LottoTicket lottoTicket = LottoTicket.of(descendingLottoNumbers);
        List<String> expected = Arrays.asList(ascendingLottoNumbers);

        // then
        assertThat(lottoTicket.toString()).isEqualTo(expected.toString());
    }
}
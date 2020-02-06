package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    private LottoTickets lottoTickets;
    private int lottoCount = 5;

    @BeforeEach
    void setUp() {
        lottoTickets = LottoTickets.with(lottoCount);

    }

    @Test
    void lottoCount만큼_로또가_만들어져야한다() {
        // then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(lottoCount);
    }

    @Test
    void 로또가_중복될_경우_예외처리된다() {
        // given

        // when

        // then

    }

}
package lottogame.domain;

import lottogame.domain.lottoticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
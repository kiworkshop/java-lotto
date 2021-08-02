package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    @DisplayName("로또 넘버 6개를 인자로 받아 로또 티켓 객체를 생성한다")
    void create() {
        //given //when
        LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);

        //then
        assertThat(lottoTicket.lottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 넘버가 6개 보다 적은 경우 예외가 발생한다.")
    void less_then_lotto_size() {
        //given //when //then
        assertThatThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 넘버가 6개 보다 많은 경우 예외가 발생한다.")
    void more_then_lotto_size() {
        //given //when //then
        assertThatThrownBy(() -> new LottoTicket(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복될 경우 예외가 발생한다")
    void duplicate_lotto_numbers() {
        //given //when //then
        assertThatThrownBy(() -> new LottoTicket(1, 1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

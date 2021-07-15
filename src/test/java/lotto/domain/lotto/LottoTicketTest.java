package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 넘버 6개를 인자로 받아 로또 티켓 객체를 생성한다")
    void create() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<LottoNumber> lottoNumbers = lottoGenerator.issueAutoLottoNumbers();

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket.lottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 중복될 경우 예외가 발생한다")
    void duplicate_lotto_numbers() {
        //given
        List<LottoNumber> lottoNumbers = Stream.of(1, 1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

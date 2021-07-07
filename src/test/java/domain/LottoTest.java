package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    static LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또를_생성하면_로또_로또번호가_부여된다() {
        //given
        Lotto lotto = new Lotto(lottoMachine.createRandomNumber());
        //when
        //than
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumbers().stream().distinct().count()).isEqualTo(6);
    }
}

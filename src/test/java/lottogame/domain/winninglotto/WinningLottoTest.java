package lottogame.domain.winninglotto;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.service.ManualLottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private final ManualLottoService manualLottoService = new ManualLottoService();
    private LottoTicket lottoResult;
    private String firstRankLottoNumbers;
    private String otherRankLottoNumbers;

    @BeforeEach
    void setUp() {
        String lottoResultInput = "1,3,5,7,9,11";
        lottoResult = manualLottoService.generateLottoTicket(lottoResultInput);

        firstRankLottoNumbers = "1,3,5,7,9,11";
        otherRankLottoNumbers = "2,4,6,8,10,12";
    }

    @Test
    void 로또1등을_잘_찾아내는가() {
        //given
        LottoTicket lottoTicket = LottoTicket.of(firstRankLottoNumbers);

        //when
        WinningLotto winningLotto = WinningLotto.computeLottoStatistics(lottoTicket, lottoResult);

        //then
        assertThat(winningLotto).isEqualTo(WinningLotto.FIRST);
    }

    @Test
    void 로또꽝을_잘_찾아내는가() {
        //given
        LottoTicket lottoTicket = LottoTicket.of(otherRankLottoNumbers);

        //when
        WinningLotto winningLotto = WinningLotto.computeLottoStatistics(lottoTicket, lottoResult);

        //then
        assertThat(winningLotto).isEqualTo(WinningLotto.OTHERS);
    }
}
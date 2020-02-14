package lottogame.domain.winninglotto;

import lottogame.domain.lottoticket.LottoTicket;
import lottogame.service.ManualLottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private final ManualLottoService manualLottoService = new ManualLottoService();
    private LottoTicket lottoResult;
    private int bonusNumber;
    private String firstRankLottoNumbers;
    private String secondRankLottoNumbers;
    private String thirdRankLottoNumbers;
    private String otherRankLottoNumbers;

    @BeforeEach
    void setUp() {
        String lottoResultInput = "1,3,5,7,9,11";
        lottoResult = manualLottoService.generateLottoTicket(lottoResultInput);
        bonusNumber = 13;

        firstRankLottoNumbers = "1,3,5,7,9,11";
        secondRankLottoNumbers = "1,3,5,7,9,13";
        thirdRankLottoNumbers = "1,3,5,7,9,45";
        otherRankLottoNumbers = "2,4,6,8,10,12";
    }

    @Test
    void 로또1등을_잘_찾아내는가() {
        //given
        LottoTicket lottoTicket = LottoTicket.createWith(firstRankLottoNumbers);

        //when
        WinningLotto winningLotto = WinningLotto.createWith(lottoTicket, lottoResult, bonusNumber);

        //then
        assertThat(winningLotto).isEqualTo(WinningLotto.FIRST);
    }

    @Test
    void 로또2등과_3등을_잘_구분하는가() {
        // given
        LottoTicket secondRanklottoTicket = LottoTicket.createWith(secondRankLottoNumbers);
        LottoTicket thirdRanklottoTicket = LottoTicket.createWith(thirdRankLottoNumbers);

        // when
        WinningLotto secondRankWinningLotto = WinningLotto.createWith(secondRanklottoTicket, lottoResult, bonusNumber);
        WinningLotto thirdRankWinningLotto = WinningLotto.createWith(thirdRanklottoTicket, lottoResult, bonusNumber);

        // then
        assertThat(secondRankWinningLotto).isEqualTo(WinningLotto.SECOND);
        assertThat(thirdRankWinningLotto).isEqualTo(WinningLotto.THIRD);
    }

    @Test
    void 로또꽝을_잘_찾아내는가() {
        //given
        LottoTicket lottoTicket = LottoTicket.createWith(otherRankLottoNumbers);

        //when
        WinningLotto winningLotto = WinningLotto.createWith(lottoTicket, lottoResult, bonusNumber);

        //then
        assertThat(winningLotto).isEqualTo(WinningLotto.OTHERS);
    }
}
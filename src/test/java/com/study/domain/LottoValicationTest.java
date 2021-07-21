package com.study.domain;

import com.study.enums.Rank;
import com.study.enums.RankMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoValicationTest {
    LottoValication lottoValication = new LottoValication();

    @Test
    void _1에서_45_사이의_로또번호와_중복된_보너스번호_입력_하면_에러_리턴() {
        //given
        int bonusNumbers = 45;
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(45);
        //when

        //then
        assertThatThrownBy(
                () -> lottoValication.checkBonusDuplicate(bonusNumbers, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 숫자의 범위가 1-45가 아닐 경우 예외가 발생한다.")
    void checkBound() {
        //given
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(0);

        //when

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lottoValication.lottoNumberValidate(winningNumber));
    }

    @Test
    @DisplayName("입력 숫자가 음수 일 경우 경우 예외가 발생한다.")
    void checkBoundMinus() {
        //given
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(-45);

        //when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lottoValication.lottoNumberValidate(winningNumber));
    }

    @Test
    void _1에서_45_사이의_로또보너스번호_입력_하면_숫자로_리턴() {
        //given
        String bonusNumbers = "45";
        List<Integer> winningNumber = new ArrayList<>();
        winningNumber.add(1);
        winningNumber.add(2);
        winningNumber.add(3);
        winningNumber.add(4);
        winningNumber.add(5);
        winningNumber.add(6);
        //when
        LottoMachine machine = new LottoMachine("1000");
        int result = machine.getBonusBall(bonusNumbers, winningNumber);
        //then
        assertThat(result).isEqualTo(45);
    }

    @Test
    void 문자_100을_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "100";
        //when
        //then
        assertThatIllegalArgumentException().isThrownBy(() ->
                lottoValication.checkGivenMoney(givenMoney));
    }

    @Test
    void 문자_가를_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "가";
        //when
        //then
        assertThatThrownBy(() ->
                new LottoMachine(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_음수1000_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "-1000";
        //when
        //then
        assertThatThrownBy(() ->
                new LottoMachine(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void _1부터_45사이의_숫자중_중복되지_않는_7개를_뽑아서_오름차순으로_리턴한다() {
        //given
        LottoMachine lottoMachine = new LottoMachine("1000");
        //when
        List<Integer> lottoNumbers = lottoMachine.createRandomNumber();
        //than
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThat(lottoNumbers.stream().distinct().count()).isEqualTo(6);

    }

    @Test
    @DisplayName("1등_당첨_결과를_리턴한다")
    void getRankResult() {
        //given
        String money = "1000";
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);
        Lottos lottos = new Lottos(lottoTicket);
        //when

        RankMap rankResult = lottoMachine.getRankResult(lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //then
        assertThat(rankResult.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isZero();
        assertThat(rankResult.get(Rank.THIRD_PLACE)).isZero();
    }

    @Test
    @DisplayName("2등_당첨_결과를_리턴한다")
    void getRankResult2() {
        //given
        String money = "1000";
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);
        Lottos lottos = new Lottos(lottoTicket);

        //when

        RankMap rankResult = lottoMachine.getRankResult(lottos, Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        //then
        assertThat(rankResult.get(Rank.SECOND_PLACE)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다")
    void getProfitRate() {
        //given
        String money = "1000";
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoTicket.add(lotto);
        Lottos lottos = new Lottos(lottoTicket);
        //when
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottos, Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        double profitRate = lottoMachine.getProfitRate(rankResult);

        //then
        assertThat(profitRate).isEqualTo(2000000);
    }

    @Test
    @DisplayName("로또 수익률을 반환한다")
    void getProfitRate2() {
        //given
        String money = "5000";
        LottoMachine lottoMachine = new LottoMachine(money);
        List<Lotto> lottoTicket = new ArrayList<>();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11));
        lottoTicket.add(lotto);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);
        lottoTicket.add(lotto2);
        Lottos lottos = new Lottos(lottoTicket);
        //when
        Map<Rank, Integer> rankResult = lottoMachine.getRankResult(lottos, Arrays.asList(1, 2, 3, 11, 12, 13), 7);
        double profitRate = lottoMachine.getProfitRate(rankResult);

        //then
        assertThat(profitRate).isEqualTo(1);
    }

}



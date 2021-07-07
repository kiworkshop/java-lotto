package lotto.domain;

import lotto.parser.LottoParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

public class PrizeCountTest {

    private final String winningNumberInput = "1, 2, 3, 4, 5, 6";
    private final String bonusNumberInput = "7";
    private final WinningLotto winningLotto = new WinningLotto(winningNumberInput, bonusNumberInput);

    @Test
    @DisplayName("로또 여러 게임의 당첨 통계를 구한다")
    void testCountPrizesOfLottoSet() {
        //given
        HashSet<Lotto> lottos = new HashSet<>();
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 6")));

        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 7")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 7")));

        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 10")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 10")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 5, 10")));

        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 4, 10, 11")));

        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 3, 10, 11, 12")));

        lottos.add(new Lotto(LottoParser.generateLotto("1, 2, 10, 11, 12, 13")));
        lottos.add(new Lotto(LottoParser.generateLotto("1, 10, 11, 12, 13, 14")));
        lottos.add(new Lotto(LottoParser.generateLotto("19, 10, 11, 12, 13, 14")));
        LottoSet lottoset = new LottoSet(lottos);

        //when
        PrizeCount prizeCount = new PrizeCount(lottoset, winningLotto);

        //then
        assertThat(prizeCount.getCountFirst()).isEqualTo(1);
        assertThat(prizeCount.getCountSecond()).isEqualTo(2);
        assertThat(prizeCount.getCountThird()).isEqualTo(3);
        assertThat(prizeCount.getCountFourth()).isEqualTo(4);
        assertThat(prizeCount.getCountFifth()).isEqualTo(5);
    }
}

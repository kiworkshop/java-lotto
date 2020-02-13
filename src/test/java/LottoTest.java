import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("맞는 번호 개수를 가져와라")
    void testCheckResults() {
        //when
        Integer[] targetNumbers = {1, 2, 3, 4, 5, 6};
        Integer[] winningNumbers = {6, 7, 8, 9, 10, 11};
        Integer[] winningNumbers1 = {6, 5, 3, 9, 10, 11};
        Integer[] winningNumbers2 = {6, 5, 4, 3, 2, 1};
        List<Integer> targetNumberList = Arrays.asList(targetNumbers);
        List<Integer> winningNumberList = Arrays.asList(winningNumbers);
        List<Integer> winningNumberList1 = Arrays.asList(winningNumbers1);
        List<Integer> winningNumberList2 = Arrays.asList(winningNumbers2);
        WinningNumbers winningNumber1 = new WinningNumbers(winningNumberList, 12);
        WinningNumbers winningNumber2 = new WinningNumbers(winningNumberList1, 12);
        WinningNumbers winningNumber3 = new WinningNumbers(winningNumberList2, 12);

        //given
        LottoRank hitCount = LottoRank.checkHits(Lotto.manualGenerate(targetNumberList), winningNumber1);
        LottoRank hitCount1 = LottoRank.checkHits(Lotto.manualGenerate(targetNumberList), winningNumber2);
        LottoRank hitCount2 = LottoRank.checkHits(Lotto.manualGenerate(targetNumberList), winningNumber3);

        //then
        assertThat(hitCount).isEqualTo(LottoRank.MISS);
        assertThat(hitCount1).isEqualTo(LottoRank.FIFTH);
        assertThat(hitCount2).isEqualTo(LottoRank.FIRST);
    }
}
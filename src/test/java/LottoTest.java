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

        //given
        int hitCount = new Lotto(targetNumberList).checkHits(winningNumberList);
        int hitCount1 = new Lotto(targetNumberList).checkHits(winningNumberList1);
        int hitCount2 = new Lotto(targetNumberList).checkHits(winningNumberList2);

        //then
        assertThat(hitCount).isEqualTo(1);
        assertThat(hitCount1).isEqualTo(3);
        assertThat(hitCount2).isEqualTo(6);
    }
}
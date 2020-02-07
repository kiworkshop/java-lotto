import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

class LottoResultTest {


    @Test
    @DisplayName("상금을 계산해라")
    void testGetPrize() {
        //given
        Lottos lottos = new Lottos();
        Integer[] lottoNumber1 = {1, 2, 3, 4, 5, 6};
        Integer[] lottoNumber2 = {1, 2, 3, 4, 5, 10};
        Integer[] lottoNumber3 = {1, 2, 3, 4, 20, 10};
        Integer[] lottoNumber4 = {1, 2, 3, 30, 20, 10};
        Integer[] winningNumbers = {1, 2, 3, 4, 5, 6};
        List<Integer> winningNumberList = Arrays.asList(winningNumbers);
        Lotto lotto1 = new Lotto(Arrays.asList(lottoNumber1));
        Lotto lotto2 = new Lotto(Arrays.asList(lottoNumber2));
        Lotto lotto3 = new Lotto(Arrays.asList(lottoNumber3));
        Lotto lotto4 = new Lotto(Arrays.asList(lottoNumber4));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);

        //when
        LottoResult lottoResult = lottos.getResults(winningNumberList);

        //then
        assertThat(lottoResult.getPrize()).isEqualTo(2001555000);
    }
}
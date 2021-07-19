package lotto.domain;

import lotto.domain.dto.WinningLottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    @DisplayName("숫자가 6개인지 확인한다")
    void testWinningNumberSize() {
        // given
        List<Integer> winningNumberInput = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        Integer bonusNumberInput = 10;

        // when
        WinningLotto winningLotto = new WinningLotto(
                new WinningLottoInput(winningNumberInput, bonusNumberInput)
        );
        int size = winningLotto.getLottoNumbers().size();

        // then
        assertThat(size).isEqualTo(Lotto.LOTTO_NUMBER_SIZE);
    }

    @Test
    @DisplayName("45 초과인 값 포함할 때 예외를 던진다")
    void testInputGreaterThanUpperBoundary() {
        // given
        List<Integer> input = Arrays.stream(new int[]{1, 2, 3, 4, 5, 46}).boxed().collect(Collectors.toList());
        Integer bonus = 10;
        WinningLottoInput winningLottoInput = WinningLottoInput.builder()
                .numbers(input)
                .bonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInput);
        });
    }

    @Test
    @DisplayName("1 미만인 값 포함할 때 예외를 던진다")
    void testInputSmallerThanLowerBoundary() {
        // given
        List<Integer> input = Arrays.stream(new int[]{0, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());
        Integer bonus = 10;
        WinningLottoInput winningLottoInput = WinningLottoInput.builder()
                .numbers(input)
                .bonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInput);
        });
    }

    @Test
    @DisplayName("6개 이하의 숫자가 입력됐을 때 예외를 던진다")
    void testInputLengthLessThanStandard() {
        // given
        List<Integer> input = Arrays.stream(new int[]{1, 2, 3, 4, 5}).boxed().collect(Collectors.toList());
        Integer bonus = 10;
        WinningLottoInput winningLottoInput = WinningLottoInput.builder()
                .numbers(input)
                .bonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInput);
        });
    }

    @Test
    @DisplayName("6개 이상의 숫자가 입력됐을 때 예외를 던진다")
    void testInputLengthGreaterThanStandard() {
        // given
        List<Integer> input = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7}).boxed().collect(Collectors.toList());
        Integer bonus = 10;
        WinningLottoInput winningLottoInput = WinningLottoInput.builder()
                .numbers(input)
                .bonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInput);
        });
    }

    @Test
    @DisplayName("중복된 숫자가 입력됐을 때 예외를 던진다")
    void testInputWithDuplicatedNumbers() {
        // given
        List<Integer> input = Arrays.stream(new int[]{1, 2, 3, 3, 5, 6}).boxed().collect(Collectors.toList());
        Integer bonus = 10;
        WinningLottoInput winningLottoInput = WinningLottoInput.builder()
                .numbers(input)
                .bonus(bonus)
                .build();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLottoInput);
        });
    }

    @Test
    void testEqualityOfLottos() {
        // given
        List<Integer> lottoNumbersOne = new ArrayList<>();
        lottoNumbersOne.add(1);
        lottoNumbersOne.add(30);
        lottoNumbersOne.add(22);
        lottoNumbersOne.add(5);
        lottoNumbersOne.add(42);
        lottoNumbersOne.add(17);

        List<Integer> lottoNumbersTwo = new ArrayList<>();
        lottoNumbersTwo.add(17);
        lottoNumbersTwo.add(22);
        lottoNumbersTwo.add(5);
        lottoNumbersTwo.add(30);
        lottoNumbersTwo.add(1);
        lottoNumbersTwo.add(42);

        // when
        Lotto one = new Lotto(lottoNumbersOne);
        Lotto two = new Lotto(lottoNumbersTwo);

        // then
        assertThat(one).isEqualTo(two);
    }
}

package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PreConditionUtilTest {

    @Test
    @DisplayName("입력 값이 null 또는 빈 값인 경우 예외가 발생한다.")
    void checkNullOrEmpty() {
        //given
        String inputBlank = "";
        String inputNull = null;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> PreConditionUtil.checkNullOrEmpty(inputBlank));
        assertThrows(IllegalArgumentException.class, () -> PreConditionUtil.checkNullOrEmpty(inputNull));
    }

    @Test
    @DisplayName("입력한 문자열을 ',' 기준으로 분리해 List에 담아 반환한다.")
    void splitByComma() {
        //given
        String input = "1,3,6,7,8,9";

        //when
        List<String> winningNumbers = PreConditionUtil.splitByComma(input);

        //then
        assertThat(winningNumbers).isEqualTo(Arrays.asList("1", "3", "6", "7", "8", "9"));
    }

    @Test
    @DisplayName("문자열 리스트를 Integer 리스트로 바꾸어 반환한다.")
    void toIntegers() {
        //given
        List<String> stringListInput = Arrays.asList("1", "3", "6", "7", "8", "9");

        //when
        List<Integer> integerListConverted = PreConditionUtil.toIntegers(stringListInput);

        //then
        assertThat(integerListConverted).isEqualTo(Arrays.asList(1, 3, 6, 7, 8, 9));
    }
}
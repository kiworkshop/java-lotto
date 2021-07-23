package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
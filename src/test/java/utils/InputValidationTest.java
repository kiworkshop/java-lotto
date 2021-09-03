package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    static InputValidation inputValidation = new InputValidation();

//    @Test
//    @DisplayName("사용자가 구매 금액을 문자로 입력한 경우 예외가 발생한다.")
//    void checkGivenMoney() {
//        //given
//        String inputMoney = "천원";
//
//        //when //then
//        assertThatThrownBy(() ->
//                inputValidation.isInvalidGivenMoney(inputMoney)).
//                isInstanceOf(NumberFormatException.class);
//    }

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
        int result = inputValidation.checkBonusBall(bonusNumbers, winningNumber);
        //then
        assertThat(result).isEqualTo(45);
    }

    @Test
    void _1에서_45_사이의_로또번호와_중복된_보너스번호_입력_하면_에러_리턴() {
        //given
        String bonusNumbers = "45";
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
                () -> inputValidation.checkBonusBall(bonusNumbers, winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


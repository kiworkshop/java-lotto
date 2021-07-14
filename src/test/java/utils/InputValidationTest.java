package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidationTest {

    static InputValidation inputValidation = new InputValidation();





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

    @Test
    @DisplayName("입력 숫자의 범위가 1-45가 아닐 경우 예외가 발생한다.")
    public void checkBound() {
        //given
        int inputNumber = 46;

        //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidation.checkBound(inputNumber));
    }

    @Test
    void _1에서_45_사이를_벗어니는_로또번호를_입력하면_에러() {
        //given
        String bonusNumbers = "46";
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


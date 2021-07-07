package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {

    static InputValidation inputValidation = new InputValidation();

    @Test
    void 문자_1000을_입력받으면_숫자1000을_리턴한다() {
        //given
        String givenMoney = "1000";
        //when
        int result = inputValidation.checkGivenMoney(givenMoney);
        //then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    void 문자_100을_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "100";
        //when
        //then
        assertThatThrownBy(() ->
                inputValidation.checkGivenMoney(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_가를_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "가";
        //when
        //then
        assertThatThrownBy(() ->
                inputValidation.checkGivenMoney(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_음수1000_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "-1000";
        //when
        //then
        assertThatThrownBy(() ->
                inputValidation.checkGivenMoney(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }

//    @ParameterizedTest
//    @NullAndEmptySource
//    @DisplayName("null 또는 공백이 입력되면 예외가 발생한다.")
//    void isNullOrEmpty(String nullOrEmpty) {
//        assertThatIllegalArgumentException().isThrownBy(() -> isNullOrEmpty(nullOrEmpty))
//                .withMessage(",로 구분한 지난 주 당첨번호를 입력해주세요.");
//    }


}

